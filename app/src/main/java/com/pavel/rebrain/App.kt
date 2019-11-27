package com.pavel.rebrain

import android.app.Application
import com.pavel.rebrain.repository.ProductModeRepository
import com.pavel.rebrain.repository.ProductsRepository
import com.pavel.rebrain.util.PreferenceHelper
import timber.log.Timber

/**
 * класс приложения
 */
class App : Application() {

    companion object {
        const val APP_LOG_TAG = "FoodApp"
        lateinit var instance: App private set
    }

    val appRepository = ProductsRepository()
    val appProductModeRepository = ProductModeRepository()

    val preferenceHelper: PreferenceHelper by lazy {
        PreferenceHelper(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        instance = this
    }


}