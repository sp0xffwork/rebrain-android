package com.pavel.rebrain.screen.main.carousel.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.pavel.rebrain.screen.main.carousel.CarouselFragment

/**
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 */
class CarouselFragmentStatePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int = 5
    override fun getItem(position: Int): Fragment = CarouselFragment()
}