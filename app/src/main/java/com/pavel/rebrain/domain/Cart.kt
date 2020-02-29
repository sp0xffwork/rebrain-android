package com.pavel.rebrain.domain

/**
 * domain layer Cart
 */
data class Cart(
    val id: Int,
    val products: List<Product>,
    val productsCount: Int,
    val price: Float
)