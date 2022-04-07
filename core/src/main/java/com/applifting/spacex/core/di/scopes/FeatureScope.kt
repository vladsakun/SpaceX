package com.applifting.spacex.core.di.scopes

import javax.inject.Scope

/**
 * Created by Vlad Sakun on 06.04.2022
 */

/**
 * Scope for a feature module (fragment/activity).
 */
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class FeatureScope
