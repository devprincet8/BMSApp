package com.soarmorrow.bms.util

import android.text.TextUtils

object Validator {

    fun validLoginInput(username: String, password: String): Boolean {
        var returnVal = false

        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
           returnVal=true
        }

        return returnVal
    }
}