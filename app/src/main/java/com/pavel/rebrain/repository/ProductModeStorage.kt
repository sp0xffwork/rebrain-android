package com.pavel.rebrain.repository

import com.pavel.rebrain.App
import com.pavel.rebrain.domain.TableMode
import com.pavel.rebrain.util.PreferenceHelper

/**
 * Класс должен сохранять в SharedPreferences режим отображения списка продуктов
 */
class ProductModeStorage : Storage<TableMode> {

    override fun read(): TableMode {
        return when (App.instance.preferenceHelper.getInt(PreferenceHelper.SHOW_PRODUCT_MODE)) {
            0 -> TableMode.LIST
            1 -> TableMode.GRID
            else -> TableMode.LIST
        }
    }

    override fun save(data: TableMode) {
        App.instance.preferenceHelper.putInt(PreferenceHelper.SHOW_PRODUCT_MODE, data.ordinal)
    }

}