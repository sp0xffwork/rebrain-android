package com.pavel.rebrain.service.response

import com.pavel.rebrain.domain.ProductListAndBanners
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * service layer ProductListResponse -> ProductList
 */
@JsonClass(generateAdapter = true)
data class ProductListResponse(
    @Json(name = "data")
    val data: List<ProductResponse>,
    @Json(name = "banners")
    val banners: List<BannerResponse>
) : BaseResponse<ProductListAndBanners> {
    override fun convertToDomainModel(): ProductListAndBanners {
        return ProductListAndBanners(
            data.map {
                it.convertToDomainModel()
            },
            banners.map {
                it.convertToDomainModel()
            }
        )
    }
}