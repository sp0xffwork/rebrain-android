package com.pavel.rebrain.screen.splash

import android.os.Build
import android.os.Bundle
import android.view.View
import com.pavel.rebrain.App
import com.pavel.rebrain.R
import com.pavel.rebrain.di.component.DaggerAppComponent
import com.pavel.rebrain.di.module.AppModule
import com.pavel.rebrain.screen.base.BaseActivity
import com.pavel.rebrain.screen.intro.IntroActivity
import com.pavel.rebrain.screen.main.MainActivity
import com.pavel.rebrain.util.PreferenceHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


/**
 * Splash-экран приложения
 */
class SplashActivity : BaseActivity("SplashActivity"), CoroutineScope {

    @Inject
    lateinit var preferenceHelper: PreferenceHelper
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)

        val appComponent = App.instance.appComponent
        val splashActivityComponent = appComponent.splashActivityComponent()
        splashActivityComponent.inject(this)

        // если sdk < 19, то fullscreen. в остальных случаях прозрачный Status Bar заданный в настройках стиля
        if (Build.VERSION.SDK_INT < 19) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        launch {
            delay(500)
            // временно. для того, чтобы выполнить задание на IntroActivity
            // TODO убрать в следующем задании
            val isNeedShowIntro =
                true; //PreferenceHelper.getBoolean(this@SplashActivity, PreferenceHelper.IS_NEED_SHOW_INTRO)
            if (isNeedShowIntro) {
                IntroActivity.start(this@SplashActivity)
                preferenceHelper.putBoolean(PreferenceHelper.IS_NEED_SHOW_INTRO, false)
            } else {
                MainActivity.start(this@SplashActivity)
            }

            // переход к IntroActivity или MainActivity без возможности возврата
            finish()
        }
    }
}
