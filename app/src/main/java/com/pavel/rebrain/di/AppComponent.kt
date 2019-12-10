package com.pavel.rebrain.di

import android.content.Context
import com.pavel.rebrain.repository.AppAuthStorage
import com.pavel.rebrain.repository.ProductModeStorage
import com.pavel.rebrain.util.PreferenceHelper
import dagger.Component
import javax.inject.Singleton

/**
 * компонент приложение - главный узел
 */
@Component(modules = [ProductModeStorageModule::class, AppAuthStorageModule::class, AppModule::class, PreferenceHelperModule::class])
@Singleton
interface AppComponent {

    fun productModeStorage(): ProductModeStorage
    fun appAuthStorage(): AppAuthStorage
    fun preferenceHelper(): PreferenceHelper
    fun applicationContext(): Context

}
