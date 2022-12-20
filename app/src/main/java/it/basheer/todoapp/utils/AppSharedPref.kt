package it.basheer.todoapp.utils

import android.content.Context
import android.content.SharedPreferences

class AppSharedPref(context: Context) {
    private var sharedPref: SharedPreferences = context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)

    fun saveStringData(key: String, value: String) {
        with(sharedPref.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun getStringData(key: String) = sharedPref.getString(key, null)

    fun clearAllData() {
        sharedPref.edit().clear().apply()
    }
}