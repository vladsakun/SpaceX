package com.applifting.spacex

import android.app.Application
import android.content.Context
import com.applifting.spacex.core.app.SpaceXAppContract
import com.applifting.spacex.core.di.CoreComponent
import com.applifting.spacex.core.di.DaggerCoreComponent
import com.applifting.spacex.core.di.module.ContextModule
import com.applifting.spacex.di.AppComponent
import com.applifting.spacex.di.DaggerAppComponent

/**
 * Created by Vlad Sakun on 06.04.2022
 */
class SpaceXApp: Application(), SpaceXAppContract {

  lateinit var coreComponent: CoreComponent

  companion object{

    lateinit var appComponent: AppComponent
      private set

    /**
     * Obtain core dagger component.
     *
     * @param context The application context
     */
    @JvmStatic
    fun coreComponent(context: Context) =
      (context.applicationContext as SpaceXApp).coreComponent
  }

  override fun onCreate() {
    super.onCreate()
    initCoreDependencyInjection()
    initAppDependencyInjection()
  }

  /**
   * Initialize app dependency injection component.
   */
  private fun initAppDependencyInjection() {
    appComponent = (DaggerAppComponent
      .builder()
      .coreComponent(coreComponent)
      .build()).also {
        it.inject(this)
      }
  }

  /**
   * Initialize core dependency injection component.
   */
  private fun initCoreDependencyInjection() {
    coreComponent = DaggerCoreComponent
      .builder()
      .contextModule(ContextModule(this))
      .build()
  }

  override fun appComponent(context: Context): CoreComponent = coreComponent(context)

}