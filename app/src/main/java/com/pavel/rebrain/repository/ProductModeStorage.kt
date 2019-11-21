package com.pavel.rebrain.repository

import android.content.Context
import com.pavel.rebrain.domain.TableMode
import com.pavel.rebrain.util.PreferenceHelper

/**
 * Класс должен сохранять в SharedPreferences режим отображения списка продуктов
 */
class ProductModeStorage {

    fun read(context: Context): TableMode {
        return when (PreferenceHelper.getInt(context, PreferenceHelper.SHOW_PRODUCT_MODE)) {
            0 -> TableMode.LIST
            1 -> TableMode.GRID
            else -> TableMode.LIST
        }
    }

    fun save(context: Context, mode: TableMode) {
        PreferenceHelper.putInt(context, PreferenceHelper.SHOW_PRODUCT_MODE, mode.ordinal)
    }

}