package com.pavel.rebrain.api

import com.pavel.rebrain.service.request.CartRequest
import com.pavel.rebrain.service.response.CartResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * интерфейс для endpoints вызовов api
 */
interface ApiCart {
    @POST("order")
    fun order(@Body reques: CartRequest): Call<CartResponse>
}
