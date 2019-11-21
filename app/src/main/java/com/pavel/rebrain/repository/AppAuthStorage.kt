package com.pavel.rebrain.repository

import android.content.Context
import com.pavel.rebrain.util.PreferenceHelper

/**
 * Класс должен сохранять в SharedPreferences флаг авторизованности пользователя
 */
class AppAuthStorage {

    fun read(context: Context): Boolean {
        return PreferenceHelper.getBoolean(context, PreferenceHelper.APP_AUTH_FLAG)
    }

    fun save(context: Context, flag: Boolean) {
        PreferenceHelper.putBoolean(context, PreferenceHelper.APP_AUTH_FLAG, flag)
    }

}