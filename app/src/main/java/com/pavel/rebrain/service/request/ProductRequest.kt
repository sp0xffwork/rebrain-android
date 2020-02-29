package com.pavel.rebrain.service.request

import com.pavel.rebrain.domain.Product
import com.squareup.moshi.Json

/**
 * service layer ProductRequest
 */
class ProductRequest : BaseRequest<Product> {
    @Json(name = "id")
    var id: Int = 0
    @Json(name = "name")
    lateinit var name: String
    @Json(name = "price")
    var price: Float = 0f
    @Json(name = "image")
    lateinit var image: String
    @Json(name = "isFavorite")
    var isFavorite: Boolean = false

    override fun fromDomainModel(data: Product) {
        id = data.id
        name = data.name
        price = data.price.toFloat()
        image = data.pictureUrl
        isFavorite = data.isFavorite
    }
}
