package com.pavel.rebrain.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pavel.rebrain.domain.Product
import com.pavel.rebrain.repository.ProductsRepository
import com.pavel.rebrain.domain.TableMode

/**
 * Класс для связи данных и интерфейса
 */
class ProductListViewModel(private var productsRepository: ProductsRepository) : ViewModel() {

    val productList = MutableLiveData<MutableList<Product>>()
    val productsViewMode =
        MutableLiveData<TableMode>()

    fun getProducts() {
        productList.value = productsRepository.getProducts()
    }

    fun getProductsViewMode() {
        productsViewMode.value = productsRepository.getProductsViewMode()
    }

    fun changeProductsViewMode() {
        productsViewMode.value = productsRepository.changeProductsViewMode()
    }

}