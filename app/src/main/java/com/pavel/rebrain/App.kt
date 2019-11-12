package com.pavel.rebrain

import android.app.Application
import com.pavel.rebrain.BuildConfig
import com.pavel.rebrain.repository.ProductsRepository
import timber.log.Timber

/**
 * класс приложения
 */
class App : Application() {

    companion object {
        val APP_LOG_TAG = "FoodApp"
        lateinit var instance: App private set
    }

    var appRepository = ProductsRepository()
        private set

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        instance = this
    }


}