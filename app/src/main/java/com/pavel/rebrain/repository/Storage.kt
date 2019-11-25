package com.pavel.rebrain.repository

import android.content.Context

/**
 * интерфейс для реализации Storage
 */
interface Storage<T> {
    fun read(context: Context): T
    fun save(context: Context, data: T)
}