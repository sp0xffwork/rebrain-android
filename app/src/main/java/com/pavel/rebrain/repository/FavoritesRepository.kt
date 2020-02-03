package com.pavel.rebrain.repository

import com.pavel.rebrain.domain.Product

/**
 * класс логики формирования и хранения данных в списке избранных
 */
class FavoritesRepository {

    var favoritesList: MutableList<Product> = mutableListOf()

    /**
     * возвращает список избранных продуктов
     * @return MutableList<Product>
     */
    fun getFavorites(): MutableList<Product> {
        return favoritesList
    }

    /**
     * добавляет продукт [favorite] в список избанных
     */
    fun addFavorite(favorite: Product) {
        favoritesList.add(favorite)
    }

}