package com.pavel.rebrain.di.component

import com.pavel.rebrain.di.scope.PerScreen
import com.pavel.rebrain.screen.splash.SplashActivity
import dagger.Subcomponent

/**
 * компонент для SplashActivity
 */
@Subcomponent()
@PerScreen
interface SplashActivityComponent {

    fun inject(activity: SplashActivity)

}