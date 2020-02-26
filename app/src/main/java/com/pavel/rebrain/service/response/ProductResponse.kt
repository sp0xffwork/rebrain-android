package com.pavel.rebrain.service.response

import com.pavel.rebrain.domain.Product
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Response класс для десерализации данных с помощью Moshi
 */
@JsonClass(generateAdapter = true)
data class ProductResponse(
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "price")
    val price: Float,
    @Json(name = "image")
    val image: String,
    @Json(name = "isFavorite")
    val isFavorite: Boolean
) {
    fun convertToDomainModel(): Product {
        return Product(id.toInt(), name, price.toInt(), image, isFavorite)
    }
}