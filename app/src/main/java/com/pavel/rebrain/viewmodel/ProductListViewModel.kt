package com.pavel.rebrain.viewmodel

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pavel.rebrain.domain.Product
import com.pavel.rebrain.domain.TableMode
import com.pavel.rebrain.repository.FavoritesRepository
import com.pavel.rebrain.repository.ProductModeRepository
import com.pavel.rebrain.repository.ProductsRepository


/**
 * Класс для связи данных и интерфейса
 */
class ProductListViewModel(
    private var productsRepository: ProductsRepository,
    private var productModeRepository: ProductModeRepository,
    private var favoritesRepository: FavoritesRepository
) : ViewModel() {

    val productList = MutableLiveData<MutableList<Product>>()
    val productsViewMode = MutableLiveData<TableMode>()

    fun requestProducts(isNeedRefresh: Boolean) {
        if (isNeedRefresh) {
            // эмуляция ожидания загрузки
            Handler().postDelayed({
                productList.value = productsRepository.updateProducts()
            }, 2000)
        } else {
            productList.value = productsRepository.getProducts()
        }
    }

    fun requestProductsViewMode() {
        productsViewMode.value = productModeRepository.getProductsViewMode()
    }

    fun changeProductsViewMode() {
        productsViewMode.value = productModeRepository.changeProductsViewMode()
    }

    fun addFavorite(id: Int) {
        val product = productList.value?.find {
            it.id == id
        }
        product?.let {
            favoritesRepository.addFavorite(it)
        }
    }

}