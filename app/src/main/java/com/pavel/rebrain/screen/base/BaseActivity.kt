package com.pavel.rebrain.screen.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pavel.rebrain.App
import timber.log.Timber

@SuppressLint("Registered")
open class BaseActivity(val logTitle: String) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.tag(App.APP_LOG_TAG).i("%s.onCreate", logTitle)
    }

    override fun onStart() {
        super.onStart()
        Timber.tag(App.APP_LOG_TAG).i("%s.onStart", logTitle)
    }

    override fun onResume() {
        super.onResume()
        Timber.tag(App.APP_LOG_TAG).i("%s.onResume", logTitle)
    }

    override fun onPause() {
        super.onPause()
        Timber.tag(App.APP_LOG_TAG).i("%s.onPause", logTitle)
    }

    override fun onStop() {
        super.onStop()
        Timber.tag(App.APP_LOG_TAG).i("%s.onStop", logTitle)
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag(App.APP_LOG_TAG).i("%s.onDestroy", logTitle)
    }

}