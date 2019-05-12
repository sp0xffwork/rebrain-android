package com.pavel.rebrain.screen.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.pavel.rebrain.R
import kotlinx.android.synthetic.main.bottom_bar.view.*

/**
 * BottomBar для переключения tabs
 */
class BottomBar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {

    var l: ((View) -> Unit)? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.bottom_bar, this, true)
        orientation = HORIZONTAL
    }

    fun setOnTab1ClickListener(l: (View)->Unit) {
        tab1.setOnViewClickListener(l)
    }

    fun setOnTab2ClickListener(l: (View)->Unit) {
        tab2.setOnViewClickListener(l)
    }

}