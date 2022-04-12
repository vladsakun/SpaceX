package com.applifting.spacex.common.livedata

import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

/**
 * A lifecycle-aware observable that sends new updates
 * and can add value to queue which will be processed after the resource is released
 *
 * @see MutableLiveData
 */
class ActiveMutableLiveData<T> : MutableLiveData<T>() {

  private val values: Queue<T> = LinkedList()

  private var isActive: Boolean = false

  /**
   * Called when the number of active observers change to 1 from 0.
   *
   * If [values] is not empty -> call [setValue] for each item in [values]
   *
   * Set [isActive] to false
   */
  override fun onActive() {
    isActive = true
    while (values.isNotEmpty()) {
      setValue(values.poll())
    }
  }

  /**
   * Called when the number of active observers change from 1 to 0.
   * <p>
   * This does not mean that there are no observers left, there may still be observers but their
   * lifecycle states aren't {@link Lifecycle.State#STARTED} or {@link Lifecycle.State#RESUMED}
   * (like an Activity in the back stack).
   * <p>
   *
   * Set [isActive] to false
   */
  override fun onInactive() {
    isActive = false
  }

  /**
   * Sets the value. If [isActive] is true -> the value will be dispatched to them.
   * Otherwise the value will be add to [values] queue
   *
   * This method must be called from the main thread. If you need set a value from a background
   * thread, you can use {@link #postValue(Object)}
   *
   * @param value The new value
   */
  @MainThread
  override fun setValue(value: T) {
    if (isActive) super.setValue(value)
    else values.add(value)
  }

  suspend fun setValueSuspend(value: T) {
    withContext(Dispatchers.Main) {
      setValue(value)
    }
  }
}
