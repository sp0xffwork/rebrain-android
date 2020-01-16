package com.pavel.rebrain.repository

import com.pavel.rebrain.domain.Product
import com.pavel.rebrain.domain.util.Generator
import javax.inject.Inject

/**
 * класс логики формирования и хранения данных
 */
class ProductsRepository @Inject constructor() {

    var productList: MutableList<Product> = mutableListOf()

    fun getProducts(): MutableList<Product> {
        return productList
    }

    fun updateProducts(): MutableList<Product> {
        productList = Generator().getProducts()
        return productList
    }

}