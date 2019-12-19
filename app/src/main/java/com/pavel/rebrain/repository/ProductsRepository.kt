package com.pavel.rebrain.repository

import com.pavel.rebrain.domain.Product
import com.pavel.rebrain.domain.util.Generator
import javax.inject.Inject

/**
 * класс логики формирования и хранения данных
 */
class ProductsRepository @Inject constructor() {

    fun getProducts(): MutableList<Product> {
        return Generator().getProducts()
    }

}