package com.applifting.spacex.core.di.module

import com.applifting.spacex.core.database.company.CompanyMapper
import com.applifting.spacex.core.database.company.repository.CompanyRepositoryContract
import com.applifting.spacex.core.database.rocket.RocketMapper
import com.applifting.spacex.core.database.rocket.image.RocketImageMapper
import com.applifting.spacex.core.database.rocket.repository.RocketRepositoryContract
import com.applifting.spacex.core.network.repositories.SpaceXRepository
import com.applifting.spacex.core.network.repositories.SpaceXRepositoryContract
import com.applifting.spacex.core.network.services.SpaceXService
import com.applifting.spacex.core.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Vlad Sakun on 06.04.2022
 */
@Module
class NetworkModule {

  /**
   * Create a provider method binding for [Retrofit].
   *
   * @return Instance of retrofit.
   * @see Provides
   */
  @Singleton
  @Provides
  fun provideRetrofitBuilder(): Retrofit =
    Retrofit.Builder()
      .baseUrl(Constants.BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()

  /**
   * Create a provider method binding for [SpaceXService].
   *
   * @return Instance of spaceX service.
   */
  @Singleton
  @Provides
  fun provideSpaceXService(retrofit: Retrofit): SpaceXService = retrofit.create(SpaceXService::class.java)

  /**
   * Create a provider method binding for [SpaceXRepository].
   *
   * @return Instance of spaceX repository.
   */
  @Singleton
  @Provides
  fun provideSpaceXRepository(
    service: SpaceXService,
    rocketMapper: RocketMapper,
    rocketImageMapper: RocketImageMapper,
    companyMapper: CompanyMapper,
    rocketRepository: RocketRepositoryContract,
    companyRepository: CompanyRepositoryContract
  ): SpaceXRepositoryContract = SpaceXRepository(
    service = service,
    rocketMapper = rocketMapper,
    rocketImageMapper = rocketImageMapper,
    companyMapper = companyMapper,
    rocketRepository = rocketRepository,
    companyRepository = companyRepository
  )
}