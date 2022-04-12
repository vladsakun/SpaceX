package com.applifting.spacex.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class FragmentHelper(
  private val activity: AppCompatActivity,
  private val container: Int
) {

  fun replaceWithBackStack(fragment: Fragment) {
    changeFragment(fragment, needToReplace = true, needToAddToBackStack = true)
  }

  fun addWithBackStack(fragment: Fragment) {
    changeFragment(fragment, needToReplace = false, needToAddToBackStack = true)
  }

  fun addWithoutBackStack(fragment: Fragment) {
    changeFragment(fragment, needToReplace = false, needToAddToBackStack = false)
  }

  fun replaceWithoutBackStack(fragment: Fragment) {
    changeFragment(fragment, needToReplace = true, needToAddToBackStack = false)
  }

  private fun changeFragment(
    fragment: Fragment,
    needToReplace: Boolean,
    needToAddToBackStack: Boolean
  ) {

    activity.supportFragmentManager.beginTransaction().apply {
      if (needToReplace) replace(container, fragment, fragment::class.java.simpleName)
      else add(container, fragment, fragment::class.java.simpleName)

      if (needToAddToBackStack) addToBackStack(fragment::class.java.simpleName)

      commitAllowingStateLoss()
    }
  }
}
