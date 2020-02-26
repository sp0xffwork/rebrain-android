package com.pavel.rebrain.api.products

import com.pavel.rebrain.service.response.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * интерфейс для endpoints вызовов api
 */
interface Api {
    @GET("products")
    fun getProducts(): Call<ProductResponse>
}
