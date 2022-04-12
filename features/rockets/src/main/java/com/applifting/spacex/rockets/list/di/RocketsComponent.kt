package com.applifting.spacex.rockets.list.di

import com.applifting.spacex.core.di.CoreComponent
import com.applifting.spacex.core.di.scopes.FeatureScope
import com.applifting.spacex.rockets.list.RocketsFragment
import dagger.Component

/**
 * Created by Vlad Sakun on 07.04.2022
 */
@FeatureScope
@Component(
  modules = [RocketsModule::class],
  dependencies = [CoreComponent::class]
)
interface RocketsComponent {

  fun inject(homeFragment: RocketsFragment)
}