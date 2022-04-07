package com.applifting.spacex.rockets

import com.applifting.spacex.common.base.BaseFragment
import com.applifting.spacex.core.app.SpaceXAppContract
import com.applifting.spacex.rockets.databinding.FragmentRocketsBinding
import com.applifting.spacex.rockets.di.DaggerRocketsComponent
import com.applifting.spacex.rockets.di.RocketsModule

class RocketsFragment : BaseFragment<FragmentRocketsBinding, RocketsViewModel>(
  layoutId = R.layout.fragment_rockets
) {

  override fun onInitDependencyInjection() {
    DaggerRocketsComponent
      .builder()
      .coreComponent(
        (requireCompatActivity().application as SpaceXAppContract).provideCoreComponent(requireContext())
      )
      .rocketsModule(RocketsModule(this))
      .build()
      .inject(this)
  }
}