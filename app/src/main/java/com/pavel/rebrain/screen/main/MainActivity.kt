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

        val arrayOfPictureResIds =
            arrayOf(
                R.drawable.pic_1,
                R.drawable.pic_2,
                R.drawable.pic_3,
                R.drawable.pic_4,
                R.drawable.pic_5,
                R.drawable.pic_6,
                R.drawable.pic_7,
                R.drawable.pic_8,
                R.drawable.pic_9,
                R.drawable.pic_10
            )

        val pagerAdapter = CarouselFragmentPagerAdapter(supportFragmentManager, arrayOfPictureResIds)
        val statePagerAdapter = CarouselFragmentStatePagerAdapter(supportFragmentManager, arrayOfPictureResIds)

        pager.adapter = pagerAdapter
        //pager.adapter = statePagerAdapter
    }
}
