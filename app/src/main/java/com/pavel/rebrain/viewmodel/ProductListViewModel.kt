package com.pavel.rebrain.viewmodel

import androidx.lifecycle.ViewModel
import com.pavel.rebrain.domain.Product
import com.pavel.rebrain.repository.ProductsRepository

/**
 * Класс для связи данных и интерфейса
 */
class ProductListViewModel(private var productsRepository: ProductsRepository) : ViewModel() {

    fun getProducts(): MutableList<Product> {
        return productsRepository.getProducts()
    }

}