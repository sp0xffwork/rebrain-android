package com.pavel.rebrain.screen.main.carousel.adapter

import android.graphics.drawable.Drawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.pavel.rebrain.screen.main.carousel.CarouselFragment

/**
 * A state pager adapter
 */
class CarouselFragmentStatePagerAdapter(fm: FragmentManager, private var pictures: Array<Int>) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int = pictures.size
    override fun getItem(position: Int): Fragment = CarouselFragment.newInstance(pictures.get(position))
}
