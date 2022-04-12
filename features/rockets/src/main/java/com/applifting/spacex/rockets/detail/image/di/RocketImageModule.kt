package com.applifting.spacex.rockets.detail.image.di

import com.applifting.spacex.common.extensions.viewModel
import com.applifting.spacex.core.di.scopes.FeatureScope
import com.applifting.spacex.rockets.detail.image.RocketImageFragment
import com.applifting.spacex.rockets.detail.image.RocketImageViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Vlad Sakun on 09.04.2022
 */
@Module
class RocketImageModule(
  val fragment: RocketImageFragment
) {

  @Provides
  @FeatureScope
  fun provideRocketDetailsViewModel() = fragment.viewModel {
    RocketImageViewModel()
  }
}