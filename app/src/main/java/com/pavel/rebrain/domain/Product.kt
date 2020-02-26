package com.pavel.rebrain.domain

class Product(
    var id: Int,
    var name: String,
    var price: Int,
    val pictureUrl: String,
    val isfavorite: Boolean
)