package com.pavel.rebrain.domain

/**
 * domain layer Product
 */
class Product(
    var id: Int,
    var name: String,
    var price: Int,
    val pictureUrl: String,
    val isFavorite: Boolean
)