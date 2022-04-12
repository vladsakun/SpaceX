package com.applifting.spacex.rockets.list

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.applifting.spacex.common.base.BaseViewModel
import com.applifting.spacex.common.livedata.ActiveMutableLiveData
import com.applifting.spacex.core.database.rocket.RocketWithImage
import com.applifting.spacex.core.database.rocket.repository.RocketRepositoryContract
import com.applifting.spacex.core.extensions.formatPrice
import com.applifting.spacex.core.network.repositories.SpaceXRepositoryContract
import com.applifting.spacex.rockets.list.model.RocketsViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.util.*

class RocketsViewModel(
  private val spaceXRepository: SpaceXRepositoryContract,
  private val rocketRepository: RocketRepositoryContract
) : BaseViewModel() {

  private val _state = ActiveMutableLiveData<RocketsViewState>()
  val state: LiveData<RocketsViewState> = _state

  private var cachedRockets: List<RocketWithImage>? = null

  fun onViewCreated() {
    getRockets()
  }

  private fun getRockets() {
    rocketRepository.observeAllRocketsWithImages().onEach {
      if (it.isEmpty()) {
        _state.setValueSuspend(RocketsViewState.ShowLoader)
      }

      if (it != cachedRockets) {
        _state.setValueSuspend(RocketsViewState.SetRocketsData(it))
      }

      cachedRockets = it
    }.launchIn(viewModelScope)

    if (isNetworkConnected?.value == true) {
      viewModelScope.launch(Dispatchers.IO) {
        spaceXRepository.fetchRockets()
        _state.setValueSuspend(RocketsViewState.HideLoader)
      }
    }
  }

  fun searchTextChanged(query: String) {
    if (query.isBlank()) return

    viewModelScope.launch(Dispatchers.Default) {
      cachedRockets?.let { rocketsList ->

        val lowerCaseQuery = query.lowercase(Locale.getDefault())

        val filteredList = if (query.isDigitsOnly()) {
          rocketsList.filter {
            it.rocketEntity.costPerLaunch.formatPrice().lowercase(Locale.getDefault()).contains(lowerCaseQuery)
          }
        } else {
          rocketsList.filter {
            it.rocketEntity.name.lowercase(Locale.getDefault()).contains(lowerCaseQuery)
          }
        }

        _state.setValueSuspend(RocketsViewState.SetRocketsData(filteredList))
      }
    }
  }

  fun editTextCleared() {
    cachedRockets?.let {
      _state.setValue(RocketsViewState.SetRocketsData(it))
    }
  }
}