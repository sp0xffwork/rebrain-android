package com.pavel.rebrain.api

import com.pavel.rebrain.service.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Part

/**
 * интерфейс для endpoints вызовов api
 */
interface ApiUser {
    @GET("user")
    fun user(): Call<UserResponse>

    @PUT("user/avatar")
    fun avatar(@Part("avatar") avatar: String): Call<UserResponse>
}
