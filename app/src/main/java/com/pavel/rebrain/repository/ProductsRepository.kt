package com.pavel.rebrain.repository

import com.pavel.rebrain.domain.Product
import com.pavel.rebrain.domain.util.Generator
import javax.inject.Inject

/**
 * класс логики формирования и хранения данных
 */
class ProductsRepository @Inject constructor() {

    var productList: MutableList<Product> = mutableListOf()

    /**
     * возвращает текущий список продуктов без обращения к бэкенду
     * @return MutableList<Product>
     */
    fun getProducts(): MutableList<Product> {
        return productList
    }

    /**
     * генрирует новый (запрашивает с бэкенда) список продуктов
     */
    fun updateProducts(): MutableList<Product> {
        productList = Generator().getProducts()
        return productList
    }

}