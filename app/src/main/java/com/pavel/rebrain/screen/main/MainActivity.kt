package com.pavel.rebrain.screen.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import com.pavel.rebrain.R
import com.pavel.rebrain.screen.base.BaseActivity
import com.pavel.rebrain.screen.main.tabs.FavoritesTabFragment
import com.pavel.rebrain.screen.main.tabs.MainTabFragment
import kotlinx.android.synthetic.main.activity_main.*


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

        bottomBar.setOnTab1ClickListener {

            Toast.makeText(this, "Tab1 Click", Toast.LENGTH_SHORT).show()

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, MainTabFragment.newInstance(), MainTabFragment.FRAGMENT_TAG)
                .commit()
        }

        bottomBar.setOnTab2ClickListener {

            Toast.makeText(this, "Tab2 Click", Toast.LENGTH_SHORT).show()

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, FavoritesTabFragment.newInstance(), FavoritesTabFragment.FRAGMENT_TAG)
                .commit()
        }
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented")
    }

}
