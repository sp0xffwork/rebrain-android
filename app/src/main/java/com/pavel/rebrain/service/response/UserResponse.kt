package com.pavel.rebrain.service.response

import com.pavel.rebrain.domain.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * service layer UserResponse -> User
 */
@JsonClass(generateAdapter = true)
data class UserResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "login")
    val login: String,
    @Json(name = "avatar")
    val avatar: String
) : BaseResponse<User> {
    override fun convertToDomainModel(): User {
        return User(id, name, login, avatar)
    }
}