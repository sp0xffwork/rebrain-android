package com.pavel.rebrain.domain

/**
 * domain layer User
 */
data class User(
    val id: Int,
    val name: String,
    val login: String,
    val avatar: String
)