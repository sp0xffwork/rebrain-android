package com.pavel.rebrain

import android.app.Application
import timber.log.Timber

/**
 * класс приложения
 */
class App : Application() {

    companion object {
        const val APP_LOG_TAG = "FoodApp"
        lateinit var instance: App private set
    }

    //val appRepository = ProductsRepository()
    //lateinit var appProductModeRepository: ProductModeRepository
    //lateinit var preferenceHelper: PreferenceHelper

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        instance = this

        //preferenceHelper = PreferenceHelper(applicationContext)
        //appProductModeRepository = ProductModeRepository(ProductModeStorage(preferenceHelper))
    }


}