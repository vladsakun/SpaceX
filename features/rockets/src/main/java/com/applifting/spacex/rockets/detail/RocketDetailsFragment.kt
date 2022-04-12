package com.applifting.spacex.rockets.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.applifting.spacex.common.base.BaseFragment
import com.applifting.spacex.common.base.INITIAL_ARGS
import com.applifting.spacex.common.extensions.observe
import com.applifting.spacex.common.extensions.setOnSingleClickListener
import com.applifting.spacex.core.app.SpaceXAppContract
import com.applifting.spacex.core.database.rocket.RocketWithImage
import com.applifting.spacex.rockets.R
import com.applifting.spacex.rockets.databinding.FragmentRocketDetailsBinding
import com.applifting.spacex.rockets.detail.adapter.RocketImagesViewPagerAdapter
import com.applifting.spacex.rockets.detail.di.DaggerRocketDetailsComponent
import com.applifting.spacex.rockets.detail.di.RocketDetailsModule
import com.applifting.spacex.rockets.detail.model.RocketDetailsUIModel
import com.applifting.spacex.rockets.detail.model.RocketDetailsViewState
import com.applifting.spacex.common.R as commonR

/**
 * Created by Vlad Sakun on 09.04.2022
 */
class RocketDetailsFragment : BaseFragment<FragmentRocketDetailsBinding, RocketDetailsViewModel>(
  layoutId = R.layout.fragment_rocket_details
) {

  override fun onViewStateRestored(savedInstanceState: Bundle?) {
    super.onViewStateRestored(savedInstanceState)
    viewModel.onViewCreated()

    observe(viewModel.state, ::onStateChange)
  }

  private fun onStateChange(viewState: RocketDetailsViewState) {
    when (viewState) {
      is RocketDetailsViewState.SetupUI -> setupUI(viewState.rocketDetailsUIModel)

      is RocketDetailsViewState.GoToImage -> viewBinding.vpRocketImages.setCurrentItem(viewState.position, true)
    }
  }

  private fun setupUI(uiModel: RocketDetailsUIModel) {
    with(viewBinding) {
      vpRocketImages.offscreenPageLimit = 3
      vpRocketImages.isUserInputEnabled = false
      vpRocketImages.adapter = RocketImagesViewPagerAdapter(requireCompatActivity(), uiModel.imageFragments)

      tvRocketName.text = getString(commonR.string.rocket_details_name, uiModel.rocketName)
      tvRocketCostPerLaunch.text = getString(commonR.string.rocket_details_cost_per_launch, uiModel.costPerLaunch)
      tvRocketHeight.text = getString(commonR.string.rocket_details_height, uiModel.height)
      tvRocketWikipedia.text = getString(commonR.string.rocket_details_wikipedia_link, uiModel.wikipedia)

      ivArrowNext.setOnClickListener { viewModel.nextImage() }
      ivArrowBack.setOnClickListener { viewModel.previousImage() }
      tvRocketWikipedia.setOnSingleClickListener { openUrl(uiModel.wikipedia) }
    }
  }

  private fun openUrl(url: String) {
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    startActivity(browserIntent)
  }

  override fun onInitDependencyInjection() {
    DaggerRocketDetailsComponent
      .builder()
      .coreComponent(
        (requireCompatActivity().application as SpaceXAppContract).provideCoreComponent(requireContext())
      )
      .rocketDetailsModule(RocketDetailsModule(this))
      .build()
      .inject(this)
  }

  companion object {
    fun newInstance(rocketWithImage: RocketWithImage) = RocketDetailsFragment().apply {
      arguments = Bundle().apply {
        putParcelable(INITIAL_ARGS, rocketWithImage)
      }
    }
  }
}