package com.pavel.rebrain.repository

import android.content.Context
import com.pavel.rebrain.domain.TableMode

/**
 * класс логики формирования и хранения данных
 */
class ProductModeRepository(val context: Context) {
    private val productModeStorage: Storage<TableMode> = ProductModeStorage()

    fun getProductsViewMode(): TableMode {
        return productModeStorage.read(context)
    }

    fun changeProductsViewMode(): TableMode {
        val storedMode = productModeStorage.read(context)
        val changedMode = if (storedMode == TableMode.GRID) {
            TableMode.LIST
        } else {
            TableMode.GRID
        }
        productModeStorage.save(context, changedMode)
        return changedMode
    }
}