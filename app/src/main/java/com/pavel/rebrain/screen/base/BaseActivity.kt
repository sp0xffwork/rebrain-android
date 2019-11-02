package com.pavel.rebrain.screen.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pavel.rebrain.App
import com.pavel.rebrain.util.Logger
import timber.log.Timber

@SuppressLint("Registered")
open class BaseActivity(private val logTitle: String) : AppCompatActivity() {

    private val logger = Logger(lifecycle, logTitle)

}