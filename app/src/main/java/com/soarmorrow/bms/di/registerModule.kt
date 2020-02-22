package com.soarmorrow.bms.di

import com.soarmorrow.bms.api.Api
import com.soarmorrow.bms.constants.Config.BASE_URL
import com.soarmorrow.bms.repository.LoginRepository
import com.soarmorrow.bms.repository.RegisterRepository
import com.soarmorrow.bms.viewmodel.LoginViewModel
import com.soarmorrow.bms.viewmodel.RegisterViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


val registerModule = module {

    single { RegisterRepository(get()) }

    override
    createWebService()

    viewModel { RegisterViewModel(get()) }

}
