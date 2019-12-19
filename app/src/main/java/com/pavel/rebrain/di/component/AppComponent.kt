package com.pavel.rebrain.di.component

import android.content.Context
import com.pavel.rebrain.di.module.AppModule
import com.pavel.rebrain.di.module.PreferenceHelperModule
import com.pavel.rebrain.di.module.ProductModeStorageModule
import com.pavel.rebrain.domain.TableMode
import com.pavel.rebrain.repository.Storage
import com.pavel.rebrain.screen.main.tabs.MainTabFragment
import com.pavel.rebrain.screen.splash.SplashActivity
import com.pavel.rebrain.util.PreferenceHelper
import dagger.Component
import javax.inject.Singleton

/**
 * компонент приложения - главный узел
 */
@Component(modules = [AppModule::class, PreferenceHelperModule::class, ProductModeStorageModule::class])
@Singleton
interface AppComponent {

    fun preferenceHelper(): PreferenceHelper
    fun applicationContext(): Context
    fun productModeStorage(): Storage<TableMode>

    fun inject(fragment: MainTabFragment)
    fun inject(activity: SplashActivity)

}
