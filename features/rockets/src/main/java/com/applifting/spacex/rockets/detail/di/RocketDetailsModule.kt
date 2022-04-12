package com.applifting.spacex.rockets.detail.di

import com.applifting.spacex.common.extensions.viewModel
import com.applifting.spacex.core.di.scopes.FeatureScope
import com.applifting.spacex.rockets.detail.RocketDetailsFragment
import com.applifting.spacex.rockets.detail.RocketDetailsViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Vlad Sakun on 09.04.2022
 */
@Module
class RocketDetailsModule(
  val fragment: RocketDetailsFragment
) {

  @Provides
  @FeatureScope
  fun provideRocketDetailsViewModel() = fragment.viewModel {
    RocketDetailsViewModel()
  }
}