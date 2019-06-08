package com.pavel.rebrain.screen.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.pavel.rebrain.R
import kotlinx.android.synthetic.main.bottom_bar_button.view.*


/**
 * BottomBarButton для создания BottomBar
 *
 */
class BottomBarButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {

    private var title: String? = null
    private var picture: Drawable? = null
    private var checked: Boolean = false

    companion object {
        private val STATE_BUTTON_CHECKED = intArrayOf(R.attr.state_button_checked)
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.bottom_bar_button, this, true)
        orientation = VERTICAL
        gravity = Gravity.CENTER_HORIZONTAL
        applyAttrs(attrs)
    }

    private fun applyAttrs(attrs: AttributeSet?) {
        attrs?.let {
            context.theme.obtainStyledAttributes(
                it,
                R.styleable.BottomBarButton, 0, 0
            ).apply {
                title = getString(R.styleable.BottomBarButton_text)
                picture = getDrawable(R.styleable.BottomBarButton_image)
                checked = getBoolean(R.styleable.BottomBarButton_checked, false)
                recycle()
            }
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        text.text = title
        image.setImageDrawable(picture)
    }

    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        if (checked) {
            val drawableState = super.onCreateDrawableState(extraSpace + 1)
            mergeDrawableStates(drawableState, STATE_BUTTON_CHECKED)
            return drawableState
        } else {
            return super.onCreateDrawableState(extraSpace)
        }
    }

    fun setChecked(c: Boolean) {
        checked = c
        refreshDrawableState()
    }

    fun isChecked(): Boolean {
        return checked
    }
}