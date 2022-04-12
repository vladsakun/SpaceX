package com.applifting.spacex.core.di.module

import com.applifting.spacex.core.database.company.CompanyMapper
import com.applifting.spacex.core.database.rocket.RocketMapper
import com.applifting.spacex.core.database.rocket.image.RocketImageMapper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vlad Sakun on 07.04.2022
 */
@Module
class UtilsModule {

  @Provides
  @Singleton
  fun provideRocketsMapper() = RocketMapper()

  @Provides
  @Singleton
  fun provideRocketImageMapper() = RocketImageMapper()

  @Provides
  @Singleton
  fun provideCompanyMapper() = CompanyMapper()
}