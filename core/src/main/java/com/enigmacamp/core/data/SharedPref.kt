package com.enigmacamp.core.data

import android.content.SharedPreferences

class SharedPref(val sharedPref: SharedPreferences) {

    fun save(KEY_NAME: String, text: String) {
        val saveData: SharedPreferences.Editor = sharedPref.edit()
        saveData.putString(KEY_NAME, text)
        saveData.apply()
    }

    fun retrived(KEY_NAME: String): String? {
        return sharedPref.getString(KEY_NAME, null)
    }
}