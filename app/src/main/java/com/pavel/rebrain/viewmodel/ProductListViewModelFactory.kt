package com.pavel.rebrain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pavel.rebrain.repository.FavoritesRepository
import com.pavel.rebrain.repository.ProductModeRepository
import com.pavel.rebrain.repository.ProductsRepository
import javax.inject.Inject

/**
 * Фабрика создания ProductListViewModel с передачей параметра в конструктор
 */
class ProductListViewModelFactory @Inject constructor(
    private val productsRepository: ProductsRepository,
    private var productModeRepository: ProductModeRepository,
    private var favoritesRepository: FavoritesRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductListViewModel(
            productsRepository,
            productModeRepository,
            favoritesRepository
        ) as T
    }
}