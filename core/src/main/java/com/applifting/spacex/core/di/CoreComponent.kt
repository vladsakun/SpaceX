package com.applifting.spacex.core.di

import android.content.Context
import com.applifting.spacex.core.database.rocket.RocketDao
import com.applifting.spacex.core.di.module.ContextModule
import com.applifting.spacex.core.di.module.DatabaseModule
import com.applifting.spacex.core.di.module.NetworkModule
import com.applifting.spacex.core.network.repositories.SpaceXRepository
import com.applifting.spacex.core.network.services.SpaceXService
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Vlad Sakun on 06.04.2022
 */
@Singleton
@Component(
  modules = [
    ContextModule::class,
    NetworkModule::class,
    DatabaseModule::class
  ]
)
interface CoreComponent {

  /**
   * Provide dependency graph Context
   *
   * @return Context
   */
  fun context(): Context

  /**
   * Provide dependency graph SpaceXService
   *
   * @return SpaceXService
   */
  fun spaceXService(): SpaceXService

  /**
   * Provide dependency graph SpaceXRepository
   *
   * @return SpaceXRepository
   */
  fun spaceXRepository(): SpaceXRepository

  /**
   * Provide dependency graph RocketDao
   *
   * @return RocketDao
   */
  fun rocketDao(): RocketDao

}