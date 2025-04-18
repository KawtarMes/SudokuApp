package com.example.sudoku

import android.content.SharedPreferences
import javax.inject.Inject
import androidx.core.content.edit


class MyPrefs @Inject constructor(
    val myPrefs: SharedPreferences
) {
    private val TOKEN = "token"
    private val USER_ID = "userID"

    var userId: String
        get()= myPrefs.getString(USER_ID ,null).toString()
        set(value)= myPrefs.edit{ putString(USER_ID, value) }

    var token: String?
        get()= myPrefs.getString(TOKEN, null)
        set (value) = myPrefs.edit{ putString(TOKEN, value) }

}