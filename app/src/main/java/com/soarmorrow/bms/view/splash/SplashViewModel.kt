package com.soarmorrow.bms.view.splash

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.soarmorrow.bms.constants.AppUserStatus
import com.soarmorrow.bms.data.DataManager
import com.soarmorrow.bms.data.local.AppPreferencesHelper

class SplashViewModel : ViewModel() {
    private val SPLASH_DELAY: Long = 3000 //3 seconds
    private var mDelayHandler: Handler? = null
    lateinit var dataManager:DataManager
    val loginStatus: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    private val mRunnable: Runnable = Runnable {
        var userStatus: AppUserStatus
        var installStatus = dataManager.getInstallStatus()
        var loggedInStaus = dataManager.getLoginStatus()
        userStatus = when {
            installStatus -> AppUserStatus.FIRST_INSTALL
            loggedInStaus -> AppUserStatus.LOGGED_IN_MODE
            else -> AppUserStatus.LOGGED_OUT_MODE
        }
        loginStatus.value=userStatus.ordinal
    }

    fun startTimer(dataManager:DataManager) {
        //Initialize the Handler
        this.dataManager = dataManager
        mDelayHandler = Handler()
        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
    }
}