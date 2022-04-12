package com.applifting.spacex.common.listeners

import android.os.SystemClock
import android.view.View

const val MIN_CLICK_INTERVAL: Long = 800

/**
 * OnClickListener which allow sending an event every [MIN_CLICK_INTERVAL]
 */
abstract class OnSingleClickListener : View.OnClickListener {

  private var lastClickTime: Long = 0

  abstract fun onSingleClick(v: View)

  /**
   * Handle [onClick] action and check is elapsed time [MIN_CLICK_INTERVAL] is over
   * If time is over -> call [onSingleClick]
   * otherwise -> return
   */
  override fun onClick(v: View) {
    val currentClickTime = SystemClock.uptimeMillis()
    val elapsedTime = currentClickTime - lastClickTime

    lastClickTime = currentClickTime

    if (elapsedTime <= MIN_CLICK_INTERVAL)
      return

    onSingleClick(v)
  }
}
