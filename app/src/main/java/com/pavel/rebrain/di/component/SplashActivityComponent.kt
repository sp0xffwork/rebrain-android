package com.pavel.rebrain.di.component

import com.pavel.rebrain.di.module.AppModule
import com.pavel.rebrain.di.module.PreferenceHelperModule
import com.pavel.rebrain.screen.splash.SplashActivity
import dagger.Component
import javax.inject.Singleton

/**
 * компонент для SplashActivity
 */
@Component(modules = [AppModule::class, PreferenceHelperModule::class])
@Singleton
interface SplashActivityComponent {

    fun inject(activity: SplashActivity)

}