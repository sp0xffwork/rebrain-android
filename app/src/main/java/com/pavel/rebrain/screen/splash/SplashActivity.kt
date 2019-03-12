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


/**
 * Splash-экран приложения
 */
class SplashActivity : AppCompatActivity(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.tag("FoodApp").i("SplashActivity.onCreate")

        // если sdk < 19, то fullscreen. в остальных случаях прозрачный Status Bar заданный в настройках стиля
        if (Build.VERSION.SDK_INT < 19) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        setContentView(R.layout.activity_splash)

        launch {
            delay(500)
            // временно. для того, чтобы выполнить задание на IntroActivity
            // TODO убрать в следующем задании
            val isNeedShowIntro = true; //PreferenceHelper.getBoolean(this@SplashActivity, PreferenceHelper.IS_NEED_SHOW_INTRO)
            if (isNeedShowIntro) {
                IntroActivity.start(this@SplashActivity)
                PreferenceHelper.putBoolean(this@SplashActivity, PreferenceHelper.IS_NEED_SHOW_INTRO, false)
            }
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Timber.tag("FoodApp").i("SplashActivity.onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.tag("FoodApp").i("SplashActivity.onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.tag("FoodApp").i("SplashActivity.onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag("FoodApp").i("SplashActivity.onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag("FoodApp").i("SplashActivity.onDestroy")
    }
}
