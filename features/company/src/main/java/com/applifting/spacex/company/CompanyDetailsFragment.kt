package com.applifting.spacex.company

import com.applifting.spacex.common.base.BaseFragment
import com.applifting.spacex.company.databinding.FragmentCompanyBinding
import com.applifting.spacex.company.di.CompanyDetailsModule
import com.applifting.spacex.company.di.DaggerCompanyDetailsComponent
import com.applifting.spacex.core.app.SpaceXAppContract

class CompanyDetailsFragment : BaseFragment<FragmentCompanyBinding, CompanyDetailsViewModel>(
  layoutId = R.layout.fragment_company
) {

  override fun onInitDependencyInjection() {
    DaggerCompanyDetailsComponent
      .builder()
      .coreComponent(
        (requireCompatActivity().application as SpaceXAppContract).provideCoreComponent(requireContext())
      )
      .companyDetailsModule(CompanyDetailsModule(this))
      .build()
      .inject(this)
  }
}