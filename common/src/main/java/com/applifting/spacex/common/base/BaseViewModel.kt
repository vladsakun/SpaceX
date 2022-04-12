package com.applifting.spacex.common.base

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.applifting.spacex.common.connection.NetworkConnectionSubscriber

/**
 * Base view model to standardize and simplify initialization for this component.
 *
 * @see ViewModel
 */
abstract class BaseViewModel : ViewModel(), NetworkConnectionSubscriber {

  /**
   * Network connection live data status.
   */
  protected var isNetworkConnected: LiveData<Boolean>? = null

  /**
   * Network connection live data handler.
   */
  override fun onNetworkConnection(data: LiveData<Boolean>) {
    isNetworkConnected = data
  }

  /**
   * This method invoked in an onStop method of the BaseFragment
   * Override to add a custom behavior
   */
  open fun onStop() {
  }

  /**
   * This method invoked in an onStart method of the BaseFragment
   * Override to add a custom behavior
   */
  open fun onStart() {
  }

  open fun onCreate(arguments: Bundle?) {
  }
}
