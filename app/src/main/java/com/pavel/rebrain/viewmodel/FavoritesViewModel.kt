package com.pavel.rebrain.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pavel.rebrain.domain.Product
import com.pavel.rebrain.repository.FavoritesRepository


/**
 * Класс для связи данных и интерфейса
 */
class FavoritesViewModel(
    private var favoritesRepository: FavoritesRepository
) : ViewModel() {

    val favoritesList = MutableLiveData<MutableList<Product>>()

    /**
     * запросить список избранного
     */
    fun requestFavorites(isNeedRefresh: Boolean) {
        if (isNeedRefresh) {
            favoritesRepository.getFavorites(favoritesList, true)
        } else {
            favoritesRepository.getFavorites(favoritesList, false)
        }
    }

    /**
     * удалить продут из избранного
     */
    fun removeFavorite(id: Int) {
        val favorites = favoritesList.value
        val favorite = favorites?.find {
            it.id == id
        }
        favorite?.let {
            favorites.remove(it)
        }
        favoritesList.value = favorites
    }
}