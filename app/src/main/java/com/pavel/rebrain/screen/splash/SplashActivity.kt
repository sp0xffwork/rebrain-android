package com.pavel.rebrain.screen.splash

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pavel.rebrain.R
import com.pavel.rebrain.screen.intro.IntroActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.pavel.rebrain.util.PreferenceHelper
import timber.log.Timber
import kotlin.coroutines.CoroutineContext


class SplashActivity : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.tag("FoodApp").d("SplashActivity.onCreate")

        // если sdk < 19, то fullscreen. в остальных случаях прозрачный Status Bar заданный в настройках стиля
        if (Build.VERSION.SDK_INT < 19) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        setContentView(R.layout.activity_splash)

        launch {
            delay(500)
            val isNeedShowIntro = PreferenceHelper.getBoolean(this@SplashActivity, PreferenceHelper.IS_NEED_SHOW_INTRO)
            if (isNeedShowIntro) {
                IntroActivity.start(this@SplashActivity)
                PreferenceHelper.putBoolean(this@SplashActivity, PreferenceHelper.IS_NEED_SHOW_INTRO, false)
            }
            finish()
        }
    }
}
