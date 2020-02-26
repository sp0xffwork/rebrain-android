package com.pavel.rebrain.repository

import com.pavel.rebrain.App
import com.pavel.rebrain.api.products.Api
import com.pavel.rebrain.domain.Product
import com.pavel.rebrain.domain.util.Generator
import okhttp3.ResponseBody
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
            object : retrofit2.Callback<ResponseBody> {
                override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                    Timber.tag(App.APP_LOG_TAG).i("newCall.enqueue error is: %s", t.message)
                }

                override fun onResponse(
                    call: retrofit2.Call<ResponseBody>,
                    response: retrofit2.Response<ResponseBody>
                ) {
                    val message = if (response.code() > 200) {
                        response.errorBody()?.string()
                    } else {
                        response.body()?.string()
                    }

                    Timber.tag(App.APP_LOG_TAG)
                        .i("newCall.enqueue response is: %s", message)
                }
            }
        )

        productList = Generator().getProducts()
        return productList
    }

}