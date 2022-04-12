package com.applifting.spacex.rockets.detail.di

import com.applifting.spacex.core.di.CoreComponent
import com.applifting.spacex.core.di.scopes.FeatureScope
import com.applifting.spacex.rockets.detail.RocketDetailsFragment
import dagger.Component

/**
 * Created by Vlad Sakun on 09.04.2022
 */
@FeatureScope
@Component(
  dependencies = [CoreComponent::class],
  modules = [RocketDetailsModule::class]
)
interface RocketDetailsComponent {

  fun inject(fragment: RocketDetailsFragment)
}