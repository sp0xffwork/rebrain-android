package com.pavel.rebrain.api.products

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("products")
    fun getProducts(): Call<ResponseBody>
}
