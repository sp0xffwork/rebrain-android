package com.pavel.rebrain.repository

import com.pavel.rebrain.App
import com.pavel.rebrain.api.products.Api
import com.pavel.rebrain.domain.Product
import com.pavel.rebrain.domain.util.Generator
import com.pavel.rebrain.service.response.ProductResponse
import timber.log.Timber
import javax.inject.Inject

/**
 * класс логики формирования и хранения данных
 */
class ProductsRepository @Inject constructor(private val api: Api) {

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
        api.getProducts().enqueue(
            object : retrofit2.Callback<ProductResponse> {
                override fun onFailure(call: retrofit2.Call<ProductResponse>, t: Throwable) {
                    Timber.tag(App.APP_LOG_TAG).i("getProducts.enqueue error is: %s", t.message)
                }

                override fun onResponse(
                    call: retrofit2.Call<ProductResponse>,
                    response: retrofit2.Response<ProductResponse>
                ) {
                    val message = if (response.code() > 200) {
                        response.errorBody()?.string()
                    } else {
                        val productResponse = response.body()
                        val productDomain = productResponse?.convertToDomainModel()
                        productDomain?.id ?: ""
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