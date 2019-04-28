package com.pavel.rebrain.screen.intro

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import com.pavel.rebrain.R
import com.pavel.rebrain.screen.base.BaseActivity
import com.pavel.rebrain.screen.main.MainActivity
import kotlinx.android.synthetic.main.activity_intro.*

/**
 * Интро-экран приложения
 */
class IntroActivity : BaseActivity("IntroActivity") {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, IntroActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
}
