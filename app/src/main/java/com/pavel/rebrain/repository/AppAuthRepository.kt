package com.pavel.rebrain.repository

import android.content.Context

/**
 * класс логики формирования и хранения данных
 */
class AppAuthRepository(val context: Context) {
    private val appAuthStorage: Storage<Boolean> = AppAuthStorage()

    fun getAuthFlag(): Boolean {
        return appAuthStorage.read(context)
    }

    fun setAuthFlag(flag: Boolean) {
        appAuthStorage.save(context, flag)
    }
}