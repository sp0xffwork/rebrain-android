package com.pavel.rebrain.api

import com.pavel.rebrain.service.request.AuthRequest
import com.pavel.rebrain.service.response.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * интерфейс для endpoints вызовов api
 */
interface ApiAuth {
    @POST("login")
    fun login(@Body request: AuthRequest): Call<UserResponse>

    @GET("logout")
    fun logout(): Call<Unit>
}
