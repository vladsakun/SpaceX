package com.applifting.spacex.core.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Vlad Sakun on 06.04.2022
 */
@Module
class ContextModule(private val application: Application) {

  /**
   * Create a provider method binding for [Context].
   *
   * @return Instance of context.
   */
  @Singleton
  @Provides
  fun provideContext(): Context = application
}