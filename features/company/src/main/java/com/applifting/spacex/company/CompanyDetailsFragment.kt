package com.applifting.spacex.company

import android.os.Bundle
import android.view.View
import com.applifting.spacex.common.base.BaseFragment
import com.applifting.spacex.common.extensions.hide
import com.applifting.spacex.common.extensions.observe
import com.applifting.spacex.common.extensions.show
import com.applifting.spacex.company.databinding.FragmentCompanyBinding
import com.applifting.spacex.company.di.CompanyDetailsModule
import com.applifting.spacex.company.di.DaggerCompanyDetailsComponent
import com.applifting.spacex.company.model.CompanyDetailsUIModel
import com.applifting.spacex.company.model.CompanyDetailsViewState
import com.applifting.spacex.core.app.SpaceXAppContract
import com.applifting.spacex.common.R as commonR

class CompanyDetailsFragment : BaseFragment<FragmentCompanyBinding, CompanyDetailsViewModel>(
  layoutId = R.layout.fragment_company
) {

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    viewModel.onViewCreated()

    observe(viewModel.state, ::onStateChange)
  }

  private fun onStateChange(state: CompanyDetailsViewState) {
    when (state) {
      is CompanyDetailsViewState.SetupUI -> setupUI(state.uiModel)

      is CompanyDetailsViewState.HideLoader -> viewBinding.progressCircular.hide()

      is CompanyDetailsViewState.ShowLoader -> viewBinding.progressCircular.show()
    }
  }

  private fun setupUI(uiModel: CompanyDetailsUIModel) {
    with(viewBinding) {
      tvCompanyName.text = uiModel.name
      tvCompanyEmployees.text = getString(commonR.string.company_employees, uiModel.employees)
      tvCompanyFounder.text = getString(commonR.string.company_founder, uiModel.founder)
      tvCompanySummary.text = getString(commonR.string.company_summary, uiModel.summary)
    }
  }

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

  companion object {
    fun newInstance() = CompanyDetailsFragment()
  }
}