package com.pavel.rebrain.screen.main.list

import android.graphics.drawable.Drawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.pavel.rebrain.screen.main.carousel.CarouselFragment

/**
 * A state pager adapter for inner carousel for recycler view
 * адаптер для управления элементами карусели
 */
class ElementCarouselFragmentStatePagerAdapter(fm: FragmentManager, private var layouts: Array<Int>) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int = layouts.size
    override fun getItem(position: Int): Fragment = ElementCarouselFragment.newInstance(layouts.get(position))
}
