package com.pavel.rebrain.screen.view

import android.content.Context
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

    enum class MainTabType {
        MAIN, FAVORITES
    }

    private val tabButtonsMap by lazy {
        hashMapOf<MainTabType, BottomBarButton>(
            MainTabType.MAIN to tab1,
            MainTabType.FAVORITES to tab2
        )
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.bottom_bar, this, true)
        orientation = HORIZONTAL
    }

    fun setCheckedButton(selectedTabType: MainTabType) {
        updateSelection(selectedTabType)
    }

    fun setOnTabClickListener(tabType: MainTabType, listener: (View) -> Unit) {
        tabButtonsMap[tabType]?.setOnClickListener {
            if (tabButtonsMap[tabType]?.isChecked() != true) {
                updateSelection(tabType)
                listener(it)
            }
        }
    }

    private fun updateSelection(selectedTabType: MainTabType = MainTabType.MAIN) {
        checkSelectedTab(selectedTabType)
        uncheckOtherTabs(selectedTabType)
    }

    private fun checkSelectedTab(selectedTabType: MainTabType) {
        tabButtonsMap[selectedTabType]?.setChecked(true)
    }

    private fun uncheckOtherTabs(selectedTabType: MainTabType) {
        tabButtonsMap.keys
            .filter { it != selectedTabType }
            .forEach {
                tabButtonsMap[it]?.setChecked(false)
            }
    }
}
