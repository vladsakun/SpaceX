package com.applifting.spacex.core.di.module

import android.content.Context
import androidx.room.Room
import com.applifting.spacex.core.database.SpaceXDatabase
import com.applifting.spacex.core.database.company.CompanyDao
import com.applifting.spacex.core.database.company.CompanyRepository
import com.applifting.spacex.core.database.rocket.RocketDao
import com.applifting.spacex.core.database.rocket.RocketRepository
import com.applifting.spacex.core.utils.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vlad Sakun on 06.04.2022
 */
@Module
class DatabaseModule {

  /**
   * Create a provider method binding for [SpaceXDatabase].
   *
   * @return Instance of spaceX database.
   */
  @Singleton
  @Provides
  fun provideSpaceXDatabase(context: Context): SpaceXDatabase =
    Room.databaseBuilder(
      context,
      SpaceXDatabase::class.java,
      Constants.DATABASE_NAME
    ).build()

  /**
   * Create a provider method binding for [RocketDao].
   *
   * @return Instance of rocket data access object.
   */
  @Singleton
  @Provides
  fun provideRocketDao(spaceXDatabase: SpaceXDatabase): RocketDao =
    spaceXDatabase.rocketDao()

  /**
   * Create a provider method binding for [RocketRepository].
   *
   * @return Instance of rocket repository.
   * @see Provides
   */
  @Singleton
  @Provides
  fun provideRocketRepository(rocketDao: RocketDao): RocketRepository =
    RocketRepository(rocketDao)

  /**
   * Create a provider method binding for [CompanyDao].
   *
   * @return Instance of company data access object.
   */
  @Singleton
  @Provides
  fun provideCompanyDao(spaceXDatabase: SpaceXDatabase): CompanyDao =
    spaceXDatabase.companyDao()

  /**
   * Create a provider method binding for [CompanyRepository].
   *
   * @return Instance of company repository.
   * @see Provides
   */
  @Singleton
  @Provides
  fun provideCompanyRepository(companyDao: CompanyDao): CompanyRepository =
    CompanyRepository(companyDao)
}