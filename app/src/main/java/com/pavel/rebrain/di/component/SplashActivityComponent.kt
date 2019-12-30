package com.pavel.rebrain.di.component

import com.pavel.rebrain.di.module.AppModule
import com.pavel.rebrain.di.module.PreferenceHelperModule
import com.pavel.rebrain.di.scope.PerScreen
import com.pavel.rebrain.screen.splash.SplashActivity
import dagger.Component

/**
 * компонент для SplashActivity
 */
@Component(modules = [AppModule::class, PreferenceHelperModule::class])
@PerScreen
interface SplashActivityComponent {

    fun inject(activity: SplashActivity)

}