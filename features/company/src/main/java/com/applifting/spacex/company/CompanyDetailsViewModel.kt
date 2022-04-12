package com.applifting.spacex.company

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.applifting.spacex.common.base.BaseViewModel
import com.applifting.spacex.common.livedata.ActiveMutableLiveData
import com.applifting.spacex.company.model.CompanyDetailsUIModel
import com.applifting.spacex.company.model.CompanyDetailsViewState
import com.applifting.spacex.core.database.company.repository.CompanyRepositoryContract
import com.applifting.spacex.core.extensions.formatPrice
import com.applifting.spacex.core.network.repositories.SpaceXRepositoryContract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class CompanyDetailsViewModel(
  private val spaceXRepository: SpaceXRepositoryContract,
  private val companyRepository: CompanyRepositoryContract
) : BaseViewModel() {

  private val _state = ActiveMutableLiveData<CompanyDetailsViewState>()
  val state: LiveData<CompanyDetailsViewState> = _state

  fun onViewCreated() {
    companyRepository.observeCompany().onEach { company ->
      company?.run {
        _state.setValueSuspend(
          CompanyDetailsViewState.SetupUI(
            CompanyDetailsUIModel(
              name = name,
              founder = founder,
              employees = employees.formatPrice(),
              summary = summary
            )
          )
        )
      }
    }.launchIn(viewModelScope)

    if (isNetworkConnected?.value == true) {
      viewModelScope.launch(Dispatchers.IO) {
        spaceXRepository.fetchCompany()
      }
    }
  }
}