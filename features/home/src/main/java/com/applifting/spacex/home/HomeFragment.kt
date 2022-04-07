package com.applifting.spacex.home

import com.applifting.spacex.common.base.BaseFragment
import com.applifting.spacex.core.app.SpaceXAppContract
import com.applifting.spacex.home.databinding.FragmentHomeBinding
import com.applifting.spacex.home.di.DaggerHomeComponent
import com.applifting.spacex.home.di.HomeModule

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
  layoutId = R.layout.fragment_home
) {

  override fun onInitDependencyInjection() {
    DaggerHomeComponent
      .builder()
      .coreComponent(
        (requireCompatActivity().application as SpaceXAppContract).provideCoreComponent(requireContext())
      )
      .homeModule(HomeModule(this))
      .build()
      .inject(this)
  }
}