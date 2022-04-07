package com.applifting.spacex.ui.rockets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RocketsViewModel : ViewModel() {

  private val _text = MutableLiveData<String>().apply {
    value = "This is slideshow Fragment"
  }
  val text: LiveData<String> = _text
}