package com.pavel.rebrain.domain

/**
 * domain layer PickupPoint
 */
data class PickupPoint(
    val id: Int,
    val location: Location,
    val name: String,
    val workingHours: String
)