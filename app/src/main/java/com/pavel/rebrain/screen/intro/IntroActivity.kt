package com.pavel.rebrain.screen.intro

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.pavel.rebrain.R
import com.pavel.rebrain.screen.main.MainActivity
import kotlinx.android.synthetic.main.activity_intro.*
import timber.log.Timber

/**
 * Интро-экран приложения
 */
class IntroActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, IntroActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.tag("FoodApp").i("IntroActivity.onCreate")

        // если sdk < 19, то fullscreen. в остальных случаях прозрачный Status Bar заданный в настройках стиля
        if (Build.VERSION.SDK_INT < 19) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        setContentView(R.layout.activity_intro)

        imageTop.setOnClickListener {
            MainActivity.start(this@IntroActivity)
            // переход к MainActivity без возможности возврата
            finishAffinity()
        }
    }

    override fun onStart() {
        super.onStart()
        Timber.tag("FoodApp").i("IntroActivity.onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.tag("FoodApp").i("IntroActivity.onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.tag("FoodApp").i("IntroActivity.onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag("FoodApp").i("IntroActivity.onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag("FoodApp").i("IntroActivity.onDestroy")
    }
}
