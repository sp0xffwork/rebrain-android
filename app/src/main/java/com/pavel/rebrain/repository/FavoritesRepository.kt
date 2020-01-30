package com.pavel.rebrain.repository

import com.pavel.rebrain.domain.Product

/**
 * класс логики формирования и хранения данных
 */
class FavoritesRepository {

    var favoritesList: MutableList<Product> = mutableListOf()

    fun getFavorites(): MutableList<Product> {
        return favoritesList
    }

    fun addFavorite(favorite: Product) {
        favoritesList.add(favorite)
    }

}