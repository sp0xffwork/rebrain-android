package com.pavel.rebrain.service.response

import com.pavel.rebrain.domain.PickupPoint
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * service layer PickupPointResponse -> PickupPoint
 */
@JsonClass(generateAdapter = true)
data class PickupPointResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "location")
    val location: LocationResponse,
    @Json(name = "name")
    val name: String,
    @Json(name = "workingHours")
    val workingHours: String
) : BaseResponse<PickupPoint> {
    override fun convertToDomainModel(): PickupPoint {
        return PickupPoint(id, location.convertToDomainModel(), name, workingHours)
    }
}