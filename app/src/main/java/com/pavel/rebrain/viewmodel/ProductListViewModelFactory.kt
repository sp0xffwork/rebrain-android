package com.pavel.rebrain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pavel.rebrain.repository.ProductsRepository

/**
 * Фабрика создания ProductListViewModel с передачей параметра в конструктор
 */
class ProductListViewModelFactory(private val productsRepository: ProductsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductListViewModel(productsRepository) as T
    }
}