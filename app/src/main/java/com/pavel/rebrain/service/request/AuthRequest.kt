package com.pavel.rebrain.service.request

import com.pavel.rebrain.domain.Auth
import com.squareup.moshi.Json

/**
 * service layer AuthRequest
 */
class AuthRequest : BaseRequest<Auth> {
    @Json(name = "login")
    lateinit var login: String
    @Json(name = "password")
    lateinit var password: String

    override fun fromDomainModel(data: Auth) {
        login = data.login
        password = data.password
    }
}
