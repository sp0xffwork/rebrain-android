package com.pavel.rebrain.repository

import com.pavel.rebrain.domain.TableMode
import javax.inject.Inject

/**
 * класс логики формирования и хранения данных
 */
class ProductModeRepository @Inject constructor(private val productModeStorage: Storage<TableMode>) {

    /**
     * @return режим отображения продуктов (список или grid)
     */
    fun getProductsViewMode(): TableMode {
        return productModeStorage.read()
    }

    /**
     * именяет режим отображения продуктов (списко или grid)
     */
    fun changeProductsViewMode(): TableMode {
        val storedMode = productModeStorage.read()
        val changedMode = if (storedMode == TableMode.GRID) {
            TableMode.LIST
        } else {
            TableMode.GRID
        }
        productModeStorage.save(changedMode)
        return changedMode
    }
}