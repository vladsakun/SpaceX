package com.applifting.spacex.rockets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.applifting.spacex.common.base.BaseViewModel

class RocketsViewModel : BaseViewModel() {

  private val _text = MutableLiveData<String>().apply {
    value = "This is gallery Fragment"
  }
  val text: LiveData<String> = _text
}