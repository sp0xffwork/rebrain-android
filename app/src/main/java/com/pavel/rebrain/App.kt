package com.pavel.rebrain

import android.app.Application
import com.pavel.rebrain.di.component.AppComponent
import com.pavel.rebrain.di.component.DaggerAppComponent
import com.pavel.rebrain.di.module.AppModule
import timber.log.Timber

/**
 * класс приложения
 */
class App : Application() {

    companion object {
        const val APP_LOG_TAG = "FoodApp"
        lateinit var instance: App private set
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

        instance = this
    }
}