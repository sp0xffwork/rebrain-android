package com.pavel.rebrain.service.response

import com.pavel.rebrain.domain.Pickpoints
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * service layer PickpointsResponse -> Pickpoints
 */
@JsonClass(generateAdapter = true)
data class PickpointsResponse(
    @Json(name = "data")
    val data: List<PickupPointResponse>
) : BaseResponse<Pickpoints> {
    override fun convertToDomainModel(): Pickpoints {
        return Pickpoints(
            data.map {
                it.convertToDomainModel()
            }
        )
    }
}