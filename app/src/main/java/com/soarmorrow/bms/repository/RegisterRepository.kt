package com.soarmorrow.bms.repository

import com.soarmorrow.bms.api.Api
import com.soarmorrow.bms.api.request.RegisterRequest
import com.soarmorrow.bms.api.response.city.CityResponse
import com.soarmorrow.bms.api.response.country.CountryResponse
import com.soarmorrow.bms.api.response.login.LoginResponse
import com.soarmorrow.bms.api.response.register.RegisterResponse
import com.soarmorrow.bms.api.response.state.StateResponse
import retrofit2.Call
import retrofit2.Response

class RegisterRepository(private val netWorkApi: Api) {

    fun doPropertyOwnerRegister(registerRequest: RegisterRequest,onData: OnRegisterResponse) {
        netWorkApi.createPropertyOwner(registerRequest).enqueue(object : retrofit2.Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                onData.onSuccess((response.body() as RegisterResponse))
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                onData.onFailure()
            }
        })
    }

    fun getCountry(onData: OnDataResponse)
    {
        netWorkApi.getCountries().enqueue(object : retrofit2.Callback<CountryResponse> {
            override fun onResponse(call: Call<CountryResponse>, response: Response<CountryResponse>) {
                onData.onSuccess((response.body()))
            }

            override fun onFailure(call: Call<CountryResponse>, t: Throwable) {
                onData.onFailure()
            }
        })
    }
    fun getState(url:String,onData: OnDataResponse)
    {
        netWorkApi.getStates(url).enqueue(object : retrofit2.Callback<StateResponse> {
            override fun onResponse(call: Call<StateResponse>, response: Response<StateResponse>) {
                onData.onSuccess((response.body()))
            }

            override fun onFailure(call: Call<StateResponse>, t: Throwable) {
                onData.onFailure()
            }
        })
    }

    fun getCity(url: String,onData: OnDataResponse)
    {
        netWorkApi.getCities(url).enqueue(object : retrofit2.Callback<CityResponse> {
            override fun onResponse(call: Call<CityResponse>, response: Response<CityResponse>) {
                onData.onSuccess((response.body()))
            }

            override fun onFailure(call: Call<CityResponse>, t: Throwable) {
                onData.onFailure()
            }
        })
    }

    interface OnRegisterResponse {
        fun onSuccess(data: RegisterResponse)
        fun onFailure()
    }
    interface OnDataResponse {
        fun onSuccess(data: Any?)
        fun onFailure()
    }

}