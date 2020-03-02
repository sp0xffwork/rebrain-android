package com.pavel.rebrain.service.response

import com.pavel.rebrain.domain.Cart
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * service layer CartResponse -> Cart
 */
@JsonClass(generateAdapter = true)
data class CartResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "products")
    val products: List<ProductResponse>,
    @Json(name = "productsCount")
    val productsCount: Int,
    @Json(name = "price")
    val price: Float
) : BaseResponse<Cart> {
    override fun convertToDomainModel(): Cart {
        val products = this.products.map {
            it.convertToDomainModel()
        }
        return Cart(id, products, productsCount, price)
    }
}