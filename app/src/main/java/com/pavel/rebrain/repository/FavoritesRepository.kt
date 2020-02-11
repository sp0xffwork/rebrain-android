package com.pavel.rebrain.repository

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import com.pavel.rebrain.domain.Product

/**
 * класс логики формирования и хранения данных в списке избранных
 */
class FavoritesRepository {

    private var favoritesList: MutableList<Product> = mutableListOf()

    /**
     * возвращает список избранных продуктов
     */
    fun getFavorites(isNeedDelay: Boolean): MutableLiveData<MutableList<Product>> {
        val delayedData = MutableLiveData<MutableList<Product>>()
        if (isNeedDelay) {
            Handler().postDelayed({
                delayedData.value = favoritesList
            }, 2000)
        } else {
            delayedData.value = favoritesList
        }
        return delayedData
    }

    /**
     * добавляет продукт [favorite] в список избанных
     */
    fun addFavorite(favorite: Product) {
        favoritesList.add(favorite)
    }

}