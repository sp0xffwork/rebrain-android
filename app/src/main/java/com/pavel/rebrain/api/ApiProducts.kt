package com.pavel.rebrain.api

import com.pavel.rebrain.service.response.PickpointsResponse
import com.pavel.rebrain.service.response.ProductListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * интерфейс для endpoints вызовов api
 */
interface ApiProducts {
    @GET("products")
    fun getProducts(@Query("is_favorite") isFavorite: Boolean): Call<ProductListResponse>

    @GET("pickups")
    fun pickups(): Call<PickpointsResponse>
}
