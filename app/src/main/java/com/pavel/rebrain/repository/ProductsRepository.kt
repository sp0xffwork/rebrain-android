package com.pavel.rebrain.repository

import com.pavel.rebrain.domain.Product
import com.pavel.rebrain.domain.util.Generator

/**
 * класс логики формирования и хранения данных
 */
class ProductsRepository {
    fun getProducts(): MutableList<Product> {
        return Generator().getProducts()
    }
}