package com.pavel.rebrain.viewmodel

import android.os.Handler
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

    fun requestFavorites(isNeedRefresh: Boolean) {
        if (isNeedRefresh) {
            // эмуляция ожидания загрузки
            Handler().postDelayed({
                favoritesList.value = favoritesRepository.getFavorites()
            }, 2000)
        } else {
            favoritesList.value = favoritesRepository.getFavorites()
        }
    }

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