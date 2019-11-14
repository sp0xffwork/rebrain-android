package com.pavel.rebrain.repository

import com.pavel.rebrain.domain.Product
import com.pavel.rebrain.domain.TableMode
import com.pavel.rebrain.domain.util.Generator

/**
 * класс логики формирования и хранения данных
 */
class ProductsRepository {
    var mode: TableMode = TableMode.LIST

    fun getProducts(): MutableList<Product> {
        return Generator().getProducts()
    }

    fun getProductsViewMode(): TableMode {
        return mode
    }

    fun changeProductsViewMode(): TableMode {
        mode = if (mode == TableMode.GRID) {
            TableMode.LIST
        } else {
            TableMode.GRID
        }
        return mode
    }



}