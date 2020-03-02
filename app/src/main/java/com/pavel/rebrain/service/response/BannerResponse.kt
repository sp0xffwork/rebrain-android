package com.pavel.rebrain.service.response

import com.pavel.rebrain.domain.Banner
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * service layer BannerResponse -> Banner
 */
@JsonClass(generateAdapter = true)
data class BannerResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val image: String
) : BaseResponse<Banner> {
    override fun convertToDomainModel(): Banner {
        return Banner(id, image)
    }
}