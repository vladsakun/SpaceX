package com.applifting.spacex.core.di.scopes

import javax.inject.Scope

/**
 * Created by Vlad Sakun on 06.04.2022
 */

/**
 * Scope for the entire app runtime.
 */
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class AppScope