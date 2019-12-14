package com.pavel.rebrain.di.component

import android.content.Context
import com.pavel.rebrain.di.module.AppModule
import com.pavel.rebrain.di.module.PreferenceHelperModule
import com.pavel.rebrain.util.PreferenceHelper
import dagger.Component
import javax.inject.Singleton

/**
 * компонент приложения - главный узел
 */
@Component(modules = [AppModule::class, PreferenceHelperModule::class])
@Singleton
interface AppComponent {

    fun preferenceHelper(): PreferenceHelper
    fun applicationContext(): Context

}
