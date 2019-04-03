package com.pavel.rebrain.screen.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pavel.rebrain.R
import com.pavel.rebrain.screen.main.carousel.adapter.CarouselFragmentPagerAdapter
import com.pavel.rebrain.screen.main.carousel.adapter.CarouselFragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Главный экран приложения
 */
class MainActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayOfPictures =
            arrayOf("1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg", "8.jpg", "9.jpg", "10.jpg")

        val pagerAdapter = CarouselFragmentPagerAdapter(supportFragmentManager)
        pagerAdapter.setPicturesArray(arrayOfPictures)
        val statePagerAdapter = CarouselFragmentStatePagerAdapter(supportFragmentManager)
        statePagerAdapter.setPicturesArray(arrayOfPictures)

        pager.adapter = pagerAdapter
        //pager.adapter = statePagerAdapter
    }
}
