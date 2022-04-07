package com.applifting.spacex.home.di

import com.applifting.spacex.common.extensions.viewModel
import com.applifting.spacex.core.di.scopes.FeatureScope
import com.applifting.spacex.home.HomeFragment
import com.applifting.spacex.home.HomeViewModel
import dagger.Module
import dagger.Provides

/**
 * Created by Vlad Sakun on 07.04.2022
 */
@Module
class HomeModule(
  val fragment: HomeFragment
) {

  @Provides
  @FeatureScope
  fun provideHomeViewModel(): HomeViewModel {
    return fragment.viewModel {
      HomeViewModel()
    }
  }
}