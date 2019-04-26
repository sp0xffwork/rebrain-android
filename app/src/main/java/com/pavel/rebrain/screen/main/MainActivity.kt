package com.pavel.rebrain.screen.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.pavel.rebrain.R
import com.pavel.rebrain.screen.base.BaseActivity
import com.pavel.rebrain.screen.main.tabs.MainTabFragment


/**
 * Главный экран приложения
 */
class MainActivity : BaseActivity("MainActivity"), OnFragmentInteractionListener {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, MainTabFragment.newInstance(), MainTabFragment.FRAGMENT_TAG)
                .commit()
        }
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented")
    }

}
