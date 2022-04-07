package com.applifting.spacex.common.connection

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import androidx.lifecycle.LiveData

/**
 * Live data holder for internet connectivity status.
 * Observe connectivity changes and propagate them to ViewModel.
 *
 * @param context An application context.
 */
@SuppressLint("MissingPermission")
class NetworkConnectionLiveData constructor(
  private val context: Context
) : LiveData<Boolean>() {

  //Handle of sending the same events
  private var isNetworkAvailable = false

  /**
   * Callback that handles connectivity intents.
   */
  private val networkCallback = object : ConnectivityManager.NetworkCallback() {

    override fun onAvailable(network: Network) {
      if (!isNetworkAvailable) postValue(true)
      isNetworkAvailable = true
    }

    override fun onLost(network: Network) {
      if (isNetworkAvailable) postValue(false)
      isNetworkAvailable = false
    }
  }

  /**
   * Connectivity manager service [ConnectivityManager].
   */
  private var cm: ConnectivityManager =
    context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

  /**
   * Called when the number of active observers change to 1 from 0.
   */
  @SuppressLint("MissingPermission")
  override fun onActive() {
    super.onActive()
    cm.registerDefaultNetworkCallback(networkCallback)
  }

  /**
   * Called when the number of active observers change from 1 to 0.
   */
  override fun onInactive() {
    super.onInactive()
    cm.unregisterNetworkCallback(networkCallback)
  }

  /**
   * Returns the current value.
   *
   * @return the current value
   */
  override fun getValue(): Boolean {
    return super.getValue() ?: cm.activeNetworkInfo?.isConnectedOrConnecting ?: false
  }
}
