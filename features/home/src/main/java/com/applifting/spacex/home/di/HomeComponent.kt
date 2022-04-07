package com.applifting.spacex.home.di

import com.applifting.spacex.core.di.CoreComponent
import com.applifting.spacex.core.di.scopes.FeatureScope
import com.applifting.spacex.home.HomeFragment
import dagger.Component

/**
 * Created by Vlad Sakun on 07.04.2022
 */
@FeatureScope
@Component(
  modules = [HomeModule::class],
  dependencies = [CoreComponent::class]
)
interface HomeComponent {

  fun inject(homeFragment: HomeFragment)
}