package com.applifting.spacex.core.app

import android.content.Context
import com.applifting.spacex.core.di.CoreComponent

/**
 * Created by Vlad Sakun on 06.04.2022
 */
interface SpaceXAppContract {

  fun provideCoreComponent(context: Context): CoreComponent?
}