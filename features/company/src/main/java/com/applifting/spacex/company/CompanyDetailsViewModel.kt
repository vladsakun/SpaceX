package com.applifting.spacex.company

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.applifting.spacex.common.base.BaseViewModel

class CompanyDetailsViewModel : BaseViewModel() {

  private val _text = MutableLiveData<String>().apply {
    value = "This is gallery Fragment"
  }
  val text: LiveData<String> = _text
}