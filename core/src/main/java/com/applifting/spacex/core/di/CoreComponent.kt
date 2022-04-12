package com.applifting.spacex.core.di

import android.content.Context
import com.applifting.spacex.core.database.company.CompanyDao
import com.applifting.spacex.core.database.company.CompanyMapper
import com.applifting.spacex.core.database.company.repository.CompanyRepositoryContract
import com.applifting.spacex.core.database.rocket.RocketDao
import com.applifting.spacex.core.database.rocket.RocketMapper
import com.applifting.spacex.core.database.rocket.image.RocketImageDao
import com.applifting.spacex.core.database.rocket.image.RocketImageMapper
import com.applifting.spacex.core.database.rocket.repository.RocketRepositoryContract
import com.applifting.spacex.core.di.module.ContextModule
import com.applifting.spacex.core.di.module.DatabaseModule
import com.applifting.spacex.core.di.module.NetworkModule
import com.applifting.spacex.core.di.module.UtilsModule
import com.applifting.spacex.core.network.repositories.SpaceXRepositoryContract
import com.applifting.spacex.core.network.services.SpaceXService
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
    DatabaseModule::class,
    UtilsModule::class
  ]
)
interface CoreComponent {

  fun context(): Context

  fun spaceXService(): SpaceXService

  fun spaceXRepository(): SpaceXRepositoryContract

  fun rocketDao(): RocketDao

  fun rocketImageDao(): RocketImageDao

  fun companyDao(): CompanyDao

  fun rocketMapper(): RocketMapper

  fun rocketImageMapper(): RocketImageMapper

  fun companyMapper(): CompanyMapper

  fun rocketRepository(): RocketRepositoryContract

  fun companyRepository(): CompanyRepositoryContract

}