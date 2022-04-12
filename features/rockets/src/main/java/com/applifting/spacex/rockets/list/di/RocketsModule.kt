package com.applifting.spacex.rockets.list.di

import com.applifting.spacex.common.extensions.viewModel
import com.applifting.spacex.core.database.rocket.repository.RocketRepositoryContract
import com.applifting.spacex.core.di.scopes.FeatureScope
import com.applifting.spacex.core.network.repositories.SpaceXRepositoryContract
import com.applifting.spacex.rockets.list.RocketsFragment
import com.applifting.spacex.rockets.list.RocketsViewModel
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
  fun provideRocketsViewModel(
    spaceXRepository: SpaceXRepositoryContract,
    rocketRepository: RocketRepositoryContract
  ): RocketsViewModel {
    return fragment.viewModel {
      RocketsViewModel(spaceXRepository, rocketRepository)
    }
  }
}