package com.pavel.rebrain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pavel.rebrain.repository.ProductModeRepository
import com.pavel.rebrain.repository.ProductsRepository

/**
 * Фабрика создания ProductListViewModel с передачей параметра в конструктор
 */
class ProductListViewModelFactory(
    private val productsRepository: ProductsRepository,
    private var productModeRepository: ProductModeRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductListViewModel(productsRepository, productModeRepository) as T
    }
}