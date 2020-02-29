package com.pavel.rebrain.domain

/**
 * domain layer ProductListAndBanners
 */
data class ProductListAndBanners(
    val items: List<Product>,
    val banners: List<Banner>
)