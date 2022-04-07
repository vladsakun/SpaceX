package com.applifting.spacex.di

import com.applifting.spacex.MainActivity
import com.applifting.spacex.SpaceXApp
import com.applifting.spacex.core.di.CoreComponent
import com.applifting.spacex.core.di.scopes.AppScope
import dagger.Component

/**
 * App component that application component's components depend on.
 *
 * @see Component
 */
@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {

    /**
     * Inject dependencies on application.
     *
     * @param application The sample application.
     */
    fun inject(application: SpaceXApp)

    /**
     * Inject dependencies on [MainActivity]
     *
     * @param activity - a [MainActivity] instance
     */
    fun inject(activity: MainActivity)
}
