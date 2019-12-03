package com.pavel.rebrain.repository

import com.pavel.rebrain.util.PreferenceHelper

/**
 * Класс должен сохранять в SharedPreferences флаг авторизованности пользователя
 */
class AppAuthStorage(val preferenceHelper: PreferenceHelper) : Storage<Boolean> {

    override fun read(): Boolean {
        return preferenceHelper.getBoolean(PreferenceHelper.APP_AUTH_FLAG)
    }

    override fun save(data: Boolean) {
        preferenceHelper.putBoolean(PreferenceHelper.APP_AUTH_FLAG, data)
    }

}