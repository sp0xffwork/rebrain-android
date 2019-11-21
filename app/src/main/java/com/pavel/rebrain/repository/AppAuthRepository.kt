package com.pavel.rebrain.repository

import android.content.Context

/**
 * класс логики формирования и хранения данных
 */
class AppAuthRepository(val context: Context) {
    private val appAuthRepository = AppAuthStorage()

    fun getAuthFlag(): Boolean {
        return appAuthRepository.read(context)
    }

    fun setAuthFlag(flag: Boolean) {
        appAuthRepository.save(context, flag)
    }
}