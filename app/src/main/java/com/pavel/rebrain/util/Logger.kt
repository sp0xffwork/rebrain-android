package com.pavel.rebrain.util

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.pavel.rebrain.App
import timber.log.Timber

class Logger(lifecycle: Lifecycle, private val logTitle: String) : LifecycleObserver {

    init {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Timber.tag(App.APP_LOG_TAG).i("%s.onCreate", logTitle)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Timber.tag(App.APP_LOG_TAG).i("%s.onStart", logTitle)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Timber.tag(App.APP_LOG_TAG).i("%s.onResume", logTitle)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Timber.tag(App.APP_LOG_TAG).i("%s.onPause", logTitle)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Timber.tag(App.APP_LOG_TAG).i("%s.onStop", logTitle)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Timber.tag(App.APP_LOG_TAG).i("%s.onDestroy", logTitle)
    }

}