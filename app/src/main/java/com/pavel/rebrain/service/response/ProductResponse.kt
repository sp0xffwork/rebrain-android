package com.pavel.rebrain.service.response

import com.pavel.rebrain.domain.Product
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Response класс для десерализации данных объекта класса ProductResponse с помощью Moshi
 *  и коныертации его в объект класса Product
 */
@JsonClass(generateAdapter = true)
data class ProductResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "price")
    val price: Float,
    @Json(name = "image")
    val image: String,
    @Json(name = "isFavorite")
    val isFavorite: Boolean
) : BaseResponse<Product> {
    override fun convertToDomainModel(): Product {
        return Product(id, name, price.toInt(), image, isFavorite)
    }
}