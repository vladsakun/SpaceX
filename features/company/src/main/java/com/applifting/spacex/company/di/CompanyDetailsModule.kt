package com.applifting.spacex.company.di

import com.applifting.spacex.common.extensions.viewModel
import com.applifting.spacex.company.CompanyDetailsFragment
import com.applifting.spacex.company.CompanyDetailsViewModel
import com.applifting.spacex.core.database.company.repository.CompanyRepositoryContract
import com.applifting.spacex.core.di.scopes.FeatureScope
import com.applifting.spacex.core.network.repositories.SpaceXRepositoryContract
import dagger.Module
import dagger.Provides

/**
 * Created by Vlad Sakun on 07.04.2022
 */
@Module
class CompanyDetailsModule(
  val fragment: CompanyDetailsFragment
) {

  @Provides
  @FeatureScope
  fun provideCompanyDetailsViewModel(
    spaceXRepository: SpaceXRepositoryContract,
    companyRepository: CompanyRepositoryContract
  ): CompanyDetailsViewModel {
    return fragment.viewModel {
      CompanyDetailsViewModel(spaceXRepository, companyRepository)
    }
  }
}