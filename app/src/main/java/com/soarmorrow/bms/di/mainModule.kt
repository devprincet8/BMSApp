package com.soarmorrow.bms.di

import com.soarmorrow.bms.api.Api
import com.soarmorrow.bms.constants.Config.BASE_URL
import com.soarmorrow.bms.repository.LoginRepository
import com.soarmorrow.bms.viewmodel.LoginViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


val mainModdule = module {

    single { LoginRepository(get()) }

    single { createWebService() }

    viewModel { LoginViewModel(get()) }

}

fun createWebService(): Api {
    val builder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
    httpClient.addInterceptor(interceptor())

    val retrofit: Retrofit = builder.client(httpClient.build())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
   return retrofit.create(
        Api::class.java)

}
private fun interceptor(): HttpLoggingInterceptor {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level=HttpLoggingInterceptor.Level.BODY
    return httpLoggingInterceptor
}