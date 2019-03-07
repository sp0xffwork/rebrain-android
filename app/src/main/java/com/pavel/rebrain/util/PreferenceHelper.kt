package com.pavel.rebrain.util

import android.content.Context
import android.preference.PreferenceManager

/**
 * Утилитный класс для удобной работы с Shared Preferences
 */
object PreferenceHelper {

    val IS_NEED_SHOW_INTRO = "is_need_show_intro"

    /**
     * @return boolean значение ключа [key]
     */
    fun getBoolean(context: Context, key: String, default: Boolean = true): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getBoolean(key, default)
    }

    /**
     * Сохраняет boolean значение [value] ключа [key]
     */
    fun putBoolean(context: Context, key: String, value: Boolean) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().putBoolean(key, value).apply()
    }
}