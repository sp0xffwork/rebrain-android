package com.pavel.rebrain.repository

/**
 * класс логики формирования и хранения данных
 */
class AppAuthRepository() {
    private val appAuthStorage: Storage<Boolean> = AppAuthStorage()

    fun getAuthFlag(): Boolean {
        return appAuthStorage.read()
    }

    fun setAuthFlag(flag: Boolean) {
        appAuthStorage.save(flag)
    }
}