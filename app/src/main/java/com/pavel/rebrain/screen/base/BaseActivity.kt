package com.pavel.rebrain.screen.base

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import com.pavel.rebrain.util.Logger

@SuppressLint("Registered")
open class BaseActivity(private val logTitle: String) : AppCompatActivity() {

    private val logger = Logger(lifecycle, logTitle)

}