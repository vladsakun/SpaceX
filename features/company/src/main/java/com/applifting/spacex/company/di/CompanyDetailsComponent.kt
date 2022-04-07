package com.applifting.spacex.company.di

import com.applifting.spacex.company.CompanyDetailsFragment
import com.applifting.spacex.core.di.CoreComponent
import com.applifting.spacex.core.di.scopes.FeatureScope
import dagger.Component

/**
 * Created by Vlad Sakun on 07.04.2022
 */
@FeatureScope
@Component(
  modules = [CompanyDetailsModule::class],
  dependencies = [CoreComponent::class]
)
interface CompanyDetailsComponent {

  fun inject(companyDetailsFragment: CompanyDetailsFragment)
}