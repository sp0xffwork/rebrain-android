package com.pavel.rebrain.service.response

import com.pavel.rebrain.domain.Location
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * service layer LocationResponse -> Location
 */
@JsonClass(generateAdapter = true)
data class LocationResponse(
    @Json(name = "lat")
    val lat: Double,
    @Json(name = "lon")
    val lon: Double
) : BaseResponse<Location> {
    override fun convertToDomainModel(): Location {
        return Location(lat, lon)
    }
}