package com.applifting.spacex.company

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CompanyDetailsViewModel : ViewModel() {

  private val _text = MutableLiveData<String>().apply {
    value = "This is gallery Fragment"
  }
  val text: LiveData<String> = _text
}