package com.pavel.rebrain.screen.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.pavel.rebrain.R
import kotlinx.android.synthetic.main.view_custom.view.*

/**
 * CustomView для создания BottomBar
 *
 */
class CustomView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {

    private var title: String? = null
    private var picture: Drawable? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.view_custom, this, true)
        orientation = VERTICAL
        gravity = Gravity.CENTER_HORIZONTAL
        applyAttrs(attrs)
    }

    private fun applyAttrs(attrs: AttributeSet?) {
        attrs?.let {
            context.theme.obtainStyledAttributes(
                it,
                R.styleable.CustomView, 0, 0
            ).apply {
                title = getString(R.styleable.CustomView_text)
                picture = getDrawable(R.styleable.CustomView_image)
                recycle()
            }
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        text.text = title
        image.setImageDrawable(picture)
    }

    fun setOnViewClickListener(l: (View) -> Unit) {
        super.setOnClickListener(l)
    }

}