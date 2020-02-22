package com.soarmorrow.bms.api

import com.soarmorrow.bms.api.response.login.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

   /* @FormUrlEncoded
    @POST("register/property-owner")
    fun createUser(
        @Body request: RegisterRequest
    ): Call<DefaultResponse>*/

    @FormUrlEncoded
    @POST("login")
    fun userLogin(
            @Field("email") email:String,
            @Field("password") password: String
    ):Call<LoginResponse>
}