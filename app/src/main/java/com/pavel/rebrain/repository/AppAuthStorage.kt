package com.pavel.rebrain.repository

import com.pavel.rebrain.App
import com.pavel.rebrain.util.PreferenceHelper

/**
 * Класс должен сохранять в SharedPreferences флаг авторизованности пользователя
 */
class AppAuthStorage : Storage<Boolean> {

    override fun read(): Boolean {
        return App.instance.preferenceHelper.getBoolean(PreferenceHelper.APP_AUTH_FLAG)
    }

    override fun save(data: Boolean) {
        App.instance.preferenceHelper.putBoolean(PreferenceHelper.APP_AUTH_FLAG, data)
    }

}