package com.applifting.spacex

import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.applifting.spacex.company.CompanyDetailsFragment
import com.applifting.spacex.core.app.BaseRouter
import com.applifting.spacex.core.database.rocket.RocketWithImage
import com.applifting.spacex.databinding.ActivityMainBinding
import com.applifting.spacex.rockets.detail.RocketDetailsFragment
import com.applifting.spacex.rockets.list.RocketsFragment
import com.applifting.spacex.utils.FragmentHelper
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), BaseRouter {

  private lateinit var binding: ActivityMainBinding
  private lateinit var fragmentHelper: FragmentHelper
  private var drawerToggle: ActionBarDrawerToggle? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    fragmentHelper = FragmentHelper(this, R.id.mainContent)

    setSupportActionBar(binding.appBarMain.toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)

    val drawerLayout: DrawerLayout = binding.drawerLayout
    val navView: NavigationView = binding.navView

    drawerToggle = ActionBarDrawerToggle(
      this,
      drawerLayout,
      binding.appBarMain.toolbar,
      com.applifting.spacex.common.R.string.nav_open,
      com.applifting.spacex.common.R.string.nav_close
    )

    drawerToggle?.isDrawerIndicatorEnabled = true
    drawerToggle?.syncState()

    drawerToggle?.let { drawerLayout.addDrawerListener(it) }

    navView.setNavigationItemSelectedListener {
      selectDrawerItem(it)
      drawerLayout.closeDrawers()
      return@setNavigationItemSelectedListener true
    }

    navView.menu.findItem(R.id.nav_company).isChecked = true
    toCompanyFragment()
  }

  override fun onPostCreate(savedInstanceState: Bundle?) {
    super.onPostCreate(savedInstanceState)
    drawerToggle?.syncState()
  }

  override fun onConfigurationChanged(newConfig: Configuration) {
    super.onConfigurationChanged(newConfig)
    drawerToggle?.onConfigurationChanged(newConfig)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (drawerToggle?.onOptionsItemSelected(item) == true) {
      return true
    }

    return super.onOptionsItemSelected(item)
  }

  private fun selectDrawerItem(item: MenuItem) {
    when (item.itemId) {
      R.id.nav_company -> {
        toCompanyFragment()
      }
      R.id.nav_rockets -> {
        toRocketsFragment()
      }
    }
  }

  private fun replaceWithoutBackStack(fragment: Fragment) {
    fragmentHelper.replaceWithoutBackStack(fragment)
  }

  private fun replaceWithBackStack(fragment: Fragment) {
    fragmentHelper.replaceWithBackStack(fragment)
  }

  override fun toRocketsFragment() {
    replaceWithoutBackStack(RocketsFragment.newInstance())
  }

  override fun toCompanyFragment() {
    replaceWithoutBackStack(CompanyDetailsFragment.newInstance())
  }

  override fun toRocketDetails(rocketWithImage: RocketWithImage) {
    replaceWithBackStack(RocketDetailsFragment.newInstance(rocketWithImage))
  }
}