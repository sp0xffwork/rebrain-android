package com.pavel.rebrain.viewmodel

import androidx.lifecycle.ViewModel
import com.pavel.rebrain.domain.Product
import com.pavel.rebrain.domain.util.Generator

/**
 * Класс для связи данных и интерфейса
 */
class ProductListViewModel : ViewModel() {

    fun getProducts(): MutableList<Product> {
        return Generator().getProducts()
    }

}