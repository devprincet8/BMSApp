package com.soarmorrow.bms.repository

import com.soarmorrow.bms.api.Api
import com.soarmorrow.bms.api.response.login.LoginResponse
import retrofit2.Call
import retrofit2.Response

class LoginRepository(private val netWorkApi: Api) {

    fun doLogin(username:String,password:String,onLoginData: OnLogin) {
        netWorkApi.userLogin(username,password).enqueue(object : retrofit2.Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                onLoginData.onSuccess((response.body() as LoginResponse))
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                onLoginData.onFailure()
            }
        })
    }

    interface OnLogin {
        fun onSuccess(data: LoginResponse)
        fun onFailure()
    }
}