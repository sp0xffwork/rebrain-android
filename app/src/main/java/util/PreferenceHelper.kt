package util

import android.content.Context
import android.preference.PreferenceManager

class PreferenceHelper {
    companion object {
        val IS_NEED_SHOW_INTRO = "is_need_show_intro"

        fun getBoolean(context: Context, key: String, default: Boolean = true): Boolean {
            val prefs = PreferenceManager.getDefaultSharedPreferences(context)
            return prefs.getBoolean(key, default)
        }

        fun putBoolean(context: Context, key: String, value: Boolean) {
            val prefs = PreferenceManager.getDefaultSharedPreferences(context)
            prefs.edit().putBoolean(key, value).apply()
        }
    }
}