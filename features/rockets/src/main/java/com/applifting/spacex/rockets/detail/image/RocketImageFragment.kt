package com.applifting.spacex.rockets.detail.image

import android.os.Bundle
import android.view.View
import com.applifting.spacex.common.base.BaseFragment
import com.applifting.spacex.common.extensions.loadImage
import com.applifting.spacex.core.app.SpaceXAppContract
import com.applifting.spacex.rockets.R
import com.applifting.spacex.rockets.databinding.FragmentRocketImageBinding
import com.applifting.spacex.rockets.detail.image.di.DaggerRocketImageComponent
import com.applifting.spacex.rockets.detail.image.di.RocketImageModule

/**
 * Created by Vlad Sakun on 09.04.2022
 */
class RocketImageFragment : BaseFragment<FragmentRocketImageBinding, RocketImageViewModel>(
  layoutId = R.layout.fragment_rocket_image
) {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    arguments?.getString(KEY_IMAGE_URL).let {
      viewBinding.ivRocketImage.loadImage(it)
    }
  }

  override fun onInitDependencyInjection() {
    DaggerRocketImageComponent
      .builder()
      .coreComponent(
        (requireCompatActivity().application as SpaceXAppContract).provideCoreComponent(requireContext())
      )
      .rocketImageModule(RocketImageModule(this))
      .build()
      .inject(this)
  }

  companion object {

    const val KEY_IMAGE_URL = "key_image_url"

    fun newInstance(imageUrl: String) = RocketImageFragment().apply {
      arguments = Bundle().apply {
        putString(KEY_IMAGE_URL, imageUrl)
      }
    }
  }
}