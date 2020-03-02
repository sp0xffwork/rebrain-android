package com.pavel.rebrain.service.request

import com.pavel.rebrain.domain.Product
import com.squareup.moshi.Json

/**
 * service layer CartRequest
 */
class CartRequest : BaseRequest<List<Product>> {
    @Json(name = "data")
    lateinit var data: List<ProductRequest>

    override fun fromDomainModel(data: List<Product>) {
        this.data = data.map {
            val product = ProductRequest()
            product.fromDomainModel(it)
            product
        }
    }
}
