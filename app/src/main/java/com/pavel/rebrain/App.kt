package com.pavel.rebrain

import android.app.Application
import com.pavel.rebrain.BuildConfig
import com.pavel.rebrain.repository.ProductModeRepository
import com.pavel.rebrain.repository.ProductsRepository
import timber.log.Timber

/**
 * класс приложения
 */
class App : Application() {

    companion object {
        const val APP_LOG_TAG = "FoodApp"
        lateinit var instance: App private set
    }

    var appRepository = ProductsRepository()
        private set

    val appProductModeRepository: ProductModeRepository by lazy {
        ProductModeRepository(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        instance = this
    }


}