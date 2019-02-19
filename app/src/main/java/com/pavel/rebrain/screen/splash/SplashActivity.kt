package com.pavel.rebrain.screen.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pavel.rebrain.R
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SplashActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var mJob: Job
    override val coroutineContext: CoroutineContext
        get() = mJob + Dispatchers.Default

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mJob = Job()

        launch {
            delay(500)
            finish()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        mJob.cancel()
    }

}
