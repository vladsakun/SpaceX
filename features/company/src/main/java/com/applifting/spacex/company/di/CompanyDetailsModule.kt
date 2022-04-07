package com.applifting.spacex.company.di

import com.applifting.spacex.common.extensions.viewModel
import com.applifting.spacex.company.CompanyDetailsFragment
import com.applifting.spacex.company.CompanyDetailsViewModel
import com.applifting.spacex.core.di.scopes.FeatureScope
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
  fun provideCompanyDetailsViewModel(): CompanyDetailsViewModel {
    return fragment.viewModel {
      CompanyDetailsViewModel()
    }
  }
}