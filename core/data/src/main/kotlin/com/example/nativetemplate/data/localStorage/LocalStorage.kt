package com.example.nativetemplate.data.localStorage

import android.content.Context
import android.content.SharedPreferences
import com.example.nativetemplate.data.util.StringPreference

class LocalStorage private constructor(context: Context) {
    companion object {
        @Volatile
        lateinit var instance: LocalStorage
            private set

        fun init(context: Context) {
            synchronized(this) {
                instance = LocalStorage(context)
            }
        }
    }

    private val pref: SharedPreferences =
        context.getSharedPreferences("LocalStorage", Context.MODE_PRIVATE)

    var appLanguage by StringPreference(pref)
    var accessToken by StringPreference(pref)
    var pinCode by StringPreference(pref)

    fun logout() {
        accessToken = ""
        pinCode = ""
        //when log out clear all data
    }
}