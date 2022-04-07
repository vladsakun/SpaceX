package com.applifting.spacex.rockets.di

import com.applifting.spacex.common.extensions.viewModel
import com.applifting.spacex.core.di.scopes.FeatureScope
import com.applifting.spacex.rockets.RocketsFragment
import com.applifting.spacex.rockets.RocketsViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Vlad Sakun on 07.04.2022
 */
@Module
class RocketsModule(
  val fragment: RocketsFragment
) {

  @Provides
  @FeatureScope
  fun provideRocketsViewModel(): RocketsViewModel {
    return fragment.viewModel {
      RocketsViewModel()
    }
  }
}