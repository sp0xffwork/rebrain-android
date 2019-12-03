package com.pavel.rebrain.repository

/**
 * класс логики формирования и хранения данных
 */
class AppAuthRepository(val appAuthStorage: Storage<Boolean>) {

    fun getAuthFlag(): Boolean {
        return appAuthStorage.read()
    }

    fun setAuthFlag(flag: Boolean) {
        appAuthStorage.save(flag)
    }
}