package com.pavel.rebrain

import android.app.Application
import com.pavel.rebrain.BuildConfig
import timber.log.Timber

class App : Application() {

    companion object {
        val APP_LOG_TAG = "FoodApp"
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}