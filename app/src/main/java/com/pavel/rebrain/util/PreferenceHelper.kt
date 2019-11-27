package com.pavel.rebrain.util

import android.content.Context
import android.preference.PreferenceManager

/**
 * Утилитный класс для удобной работы с Shared Preferences
 */
class PreferenceHelper(val context: Context) {

    companion object {
        val IS_NEED_SHOW_INTRO = "is_need_show_intro"
        val SHOW_PRODUCT_MODE = "show_product_mode"
        val APP_AUTH_FLAG = "app_auth_flag"
    }

    /**
     * @return boolean значение ключа [key]
     */
    fun getBoolean(key: String, default: Boolean = true): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getBoolean(key, default)
    }

    /**
     * Сохраняет boolean значение [value] ключа [key]
     */
    fun putBoolean(key: String, value: Boolean) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().putBoolean(key, value).apply()
    }

    /**
     * @return integer значение ключа [key]
     */
    fun getInt(key: String, default: Int = 0): Int {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getInt(key, default)
    }

    /**
     * Сохраняет integer значение [value] ключа [key]
     */
    fun putInt(key: String, value: Int) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().putInt(key, value).apply()
    }
}