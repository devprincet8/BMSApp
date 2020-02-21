package com.soarmorrow.bms.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.soarmorrow.bms.api.login.LoginResponse
import com.soarmorrow.bms.repository.LoginRepository
import org.koin.standalone.KoinComponent

class LoginViewModel(private val dataRepository: LoginRepository) : ViewModel(), KoinComponent {

    var loginResponse = MutableLiveData<LoginResponse>()

    fun doLogin(username:String,password:String) {
        dataRepository.doLogin(username,password,object : LoginRepository.OnLogin {
            override fun onSuccess(data: LoginResponse) {
                loginResponse.value = data
            }

            override fun onFailure() {
                //REQUEST FAILED
            }
        })
    }
}