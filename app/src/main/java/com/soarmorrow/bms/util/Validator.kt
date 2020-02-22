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
    fun validRegisterCompanyInput(nameOfBusiness: String, address1: String,address2: String,pin: String,tel: String,mob: String,key_contact_mob: String): Boolean {
        var returnVal = false

        if (!TextUtils.isEmpty(nameOfBusiness) &&
            !TextUtils.isEmpty(address1)&&
            !TextUtils.isEmpty(address2) &&
            !TextUtils.isEmpty(pin) &&
            !TextUtils.isEmpty(tel) &&
            !TextUtils.isEmpty(mob)
            && !TextUtils.isEmpty(key_contact_mob)) {
            returnVal=true
        }

        return returnVal
    }
    fun isPasswordMatch(password1: String,password2: String):Boolean
    {
        var returnVal = false

        if (password1 == password2) {
            returnVal=true
        }
        return  returnVal
    }
    fun validRegisterUserInput(username: String, email: String,password: String,confrmPassword: String): Boolean {
        var returnVal = false

        if (!TextUtils.isEmpty(username) &&
            !TextUtils.isEmpty(email)&&
            !TextUtils.isEmpty(password)&&
            !TextUtils.isEmpty(confrmPassword)) {
            returnVal=true
        }

        return returnVal
    }
}