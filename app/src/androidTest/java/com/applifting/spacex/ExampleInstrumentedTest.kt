package com.applifting.spacex

import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

  @get:Rule
  val activityTestRule = ActivityTestRule(MainActivity::class.java)

  @Test
  fun setUp() {
    onView(withId(R.id.drawer_layout)).check(matches((isDisplayed())))
    onView(withId(com.applifting.spacex.rockets.R.id.rvRockets)).check(doesNotExist())
    onView(withId(R.id.drawer_layout)).perform(actionOpenDrawer())
    onView(withId(R.id.nav_rockets)).perform(click())
    onView(isRoot()).perform(waitFor(1000))
    onView(withId(com.applifting.spacex.rockets.R.id.rvRockets)).check(matches((isDisplayed())))
  }

  private fun waitFor(delay: Long): ViewAction {
    return object : ViewAction {
      override fun getConstraints(): Matcher<View> = isRoot()
      override fun getDescription(): String = "wait for $delay milliseconds"
      override fun perform(uiController: UiController, v: View?) {
        uiController.loopMainThreadForAtLeast(delay)
      }
    }
  }

  private fun actionOpenDrawer(): ViewAction {
    return object : ViewAction {
      override fun getConstraints(): Matcher<View> {
        return isAssignableFrom(DrawerLayout::class.java)
      }

      override fun getDescription(): String {
        return "open drawer"
      }

      override fun perform(uiController: UiController?, view: View) {
        (view as DrawerLayout).openDrawer(GravityCompat.START)
      }
    }
  }

}