package com.pavel.rebrain.screen.main.carousel.adapter

import android.graphics.drawable.Drawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.pavel.rebrain.screen.main.carousel.CarouselFragment

/**
 * A pager adapter
 */
class CarouselFragmentPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var pictures: Array<String>? = null

    fun setPicturesArray(pictures: Array<String>) {
        this.pictures = pictures
    }

    override fun getCount(): Int = pictures?.size ?: 0
    override fun getItem(position: Int): Fragment = CarouselFragment.newInstance(pictures?.get(position))
}