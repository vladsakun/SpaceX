package com.applifting.spacex.common.connection

import androidx.lifecycle.LiveData

interface NetworkConnectionSubscriber {

  /**
   * Network connection live data handler.
   */
  fun onNetworkConnection(data: LiveData<Boolean>)
}
