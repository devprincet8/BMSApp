package com.soarmorrow.bms.api

import com.soarmorrow.bms.api.request.RegisterRequest
import com.soarmorrow.bms.api.response.city.CityResponse
import com.soarmorrow.bms.api.response.country.CountryResponse
import com.soarmorrow.bms.api.response.login.LoginResponse
import com.soarmorrow.bms.api.response.register.RegisterResponse
import com.soarmorrow.bms.api.response.state.StateResponse
import retrofit2.Call
import retrofit2.http.*

interface Api {

    @FormUrlEncoded
    @POST("login")
    fun userLogin(
            @Field("email") email:String,
            @Field("password") password: String
    ):Call<LoginResponse>


    @POST("register/property-owner")
    fun createPropertyOwner(
        @Body request: RegisterRequest
    ): Call<RegisterResponse>


    @GET("get-countries")
    fun getCountries(): Call<CountryResponse>

    @GET
    fun getStates(@Url url: String): Call<StateResponse>

    @GET
    fun getCities(@Url url: String): Call<CityResponse>
}