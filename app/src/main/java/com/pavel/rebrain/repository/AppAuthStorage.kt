package com.pavel.rebrain.repository

import android.content.Context
import com.pavel.rebrain.util.PreferenceHelper

/**
 * Класс должен сохранять в SharedPreferences флаг авторизованности пользователя
 */
class AppAuthStorage : Storage<Boolean> {

    override fun read(context: Context): Boolean {
        return PreferenceHelper.getBoolean(context, PreferenceHelper.APP_AUTH_FLAG)
    }

    override fun save(context: Context, data: Boolean) {
        PreferenceHelper.putBoolean(context, PreferenceHelper.APP_AUTH_FLAG, data)
    }

}