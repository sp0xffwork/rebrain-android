package com.pavel.rebrain.repository

/**
 * интерфейс для реализации Storage
 */
interface Storage<T> {
    fun read(): T
    fun save(data: T)
}