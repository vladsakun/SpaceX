package com.applifting.spacex.rockets.detail.image.di

import com.applifting.spacex.core.di.CoreComponent
import com.applifting.spacex.core.di.scopes.FeatureScope
import com.applifting.spacex.rockets.detail.image.RocketImageFragment
import dagger.Component

/**
 * Created by Vlad Sakun on 09.04.2022
 */
@FeatureScope
@Component(
  dependencies = [CoreComponent::class],
  modules = [RocketImageModule::class]
)
interface RocketImageComponent {

  fun inject(fragment: RocketImageFragment)
}