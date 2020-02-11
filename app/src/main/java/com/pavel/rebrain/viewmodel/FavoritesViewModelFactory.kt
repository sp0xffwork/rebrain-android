package com.pavel.rebrain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pavel.rebrain.repository.FavoritesRepository
import javax.inject.Inject

/**
 * Фабрика создания FavoritesViewModel с передачей параметра в конструктор
 */
class FavoritesViewModelFactory @Inject constructor(
    private val favoritesRepository: FavoritesRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FavoritesViewModel(favoritesRepository) as T
    }
}