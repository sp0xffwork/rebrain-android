package com.pavel.rebrain.repository

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import com.pavel.rebrain.domain.Product

/**
 * класс логики формирования и хранения данных в списке избранных
 */
class FavoritesRepository {

    var favoritesList: MutableList<Product> = mutableListOf()

    /**
     * возвращает список избранных продуктов
     */
    fun getFavorites(favoritesLiveData: MutableLiveData<MutableList<Product>>, isNeedDelay: Boolean) {
        if (isNeedDelay) {
            Handler().postDelayed({
                favoritesLiveData.value = favoritesList
            }, 2000)
        } else {
            favoritesLiveData.value = favoritesList
        }
    }

    /**
     * добавляет продукт [favorite] в список избанных
     */
    fun addFavorite(favorite: Product) {
        favoritesList.add(favorite)
    }

}