package com.soarmorrow.bms.data

import android.content.Context
import com.soarmorrow.bms.data.local.AppPreferencesHelper

class DataManager(context: Context) {
    var appPreferencesHelper: AppPreferencesHelper = AppPreferencesHelper(context)
    fun getLoginStatus(): Boolean {
        return appPreferencesHelper.isLoggedIn
    }

    fun setLoginStatus(boolean: Boolean) {
        appPreferencesHelper.isLoggedIn = boolean
    }

    fun getInstallStatus(): Boolean {
        return appPreferencesHelper.isFirstInstall
    }

    fun setInstallStatus(boolean: Boolean) {
        appPreferencesHelper.isFirstInstall = boolean
    }
}