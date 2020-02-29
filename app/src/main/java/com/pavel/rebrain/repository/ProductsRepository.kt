package com.pavel.rebrain.repository

import com.pavel.rebrain.App
import com.pavel.rebrain.api.ApiProducts
import com.pavel.rebrain.domain.Product
import com.pavel.rebrain.domain.util.Generator
import com.pavel.rebrain.service.response.ProductListResponse
import timber.log.Timber
import javax.inject.Inject

/**
 * класс логики формирования и хранения данных
 */
class ProductsRepository @Inject constructor(private val apiProducts: ApiProducts) {

    private var productList: MutableList<Product> = mutableListOf()

    /**
     * возвращает текущий список продуктов без обращения к бэкенду
     * @return MutableList<Product>
     */
    fun getProducts(): MutableList<Product> {
        return productList
    }

    /**
     * генрирует новый (запрашивает с бэкенда) список продуктов
     */
    fun updateProducts(): MutableList<Product> {
        // асинхронный запрос к api
        apiProducts.getProducts(isFavorite = false).enqueue(
            object : retrofit2.Callback<ProductListResponse> {
                override fun onFailure(call: retrofit2.Call<ProductListResponse>, t: Throwable) {
                    Timber.tag(App.APP_LOG_TAG).i("getProducts.enqueue error is: %s", t.message)
                }

                override fun onResponse(
                    call: retrofit2.Call<ProductListResponse>,
                    response: retrofit2.Response<ProductListResponse>
                ) {
                    val message = if (response.code() > 200) {
                        response.errorBody()?.string()
                    } else {
                        val productListResponse = response.body()
                        val productListDomain = productListResponse?.convertToDomainModel()
                        "Product list size = ${productListDomain?.items?.size ?: 0}"
                    }

                    Timber.tag(App.APP_LOG_TAG)
                        .i("getProducts.enqueue response is: %s", message)
                }
            }
        )

        productList = Generator().getProducts()
        return productList
    }

}