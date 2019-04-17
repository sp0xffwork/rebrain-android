package com.pavel.rebrain.screen.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pavel.rebrain.R
import com.pavel.rebrain.screen.main.carousel.adapter.CarouselFragmentPagerAdapter
import com.pavel.rebrain.screen.main.carousel.adapter.CarouselFragmentStatePagerAdapter
import com.pavel.rebrain.screen.main.tabs.MainTabFragment
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber


/**
 * Главный экран приложения
 */
class MainActivity : AppCompatActivity(), MainTabFragment.OnFragmentInteractionListener {

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
                .replace(R.id.container, MainTabFragment.newInstance(), "MainTabFragment")
                .commit()
        }

        Timber.tag("FoodApp").i("MainActivity.onCreate")

    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStart() {
        super.onStart()
        Timber.tag("FoodApp").i("MainActivity.onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.tag("FoodApp").i("MainActivity.onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.tag("FoodApp").i("MainActivity.onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag("FoodApp").i("MainActivity.onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag("FoodApp").i("SplashActivity.onDestroy")
    }

}
