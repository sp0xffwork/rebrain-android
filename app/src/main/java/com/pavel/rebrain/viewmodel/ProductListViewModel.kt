package com.pavel.rebrain.viewmodel

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pavel.rebrain.domain.Product
import com.pavel.rebrain.domain.TableMode
import com.pavel.rebrain.repository.ProductsRepository


/**
 * Класс для связи данных и интерфейса
 */
class ProductListViewModel(private var productsRepository: ProductsRepository) : ViewModel() {

    val productList = MutableLiveData<MutableList<Product>>()
    val productsViewMode = MutableLiveData<TableMode>()

    fun requestProducts() {
        // эмуляция ожидания загрузки
        Handler().postDelayed({
            productList.value = productsRepository.getProducts()
        }, 2000)
    }

    fun requestProductsViewMode() {
        productsViewMode.value = productsRepository.getProductsViewMode()
    }

    fun changeProductsViewMode() {
        productsViewMode.value = productsRepository.changeProductsViewMode()
    }
}