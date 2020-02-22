package com.soarmorrow.bms.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.soarmorrow.bms.api.request.RegisterRequest
import com.soarmorrow.bms.api.response.city.City
import com.soarmorrow.bms.api.response.city.CityResponse
import com.soarmorrow.bms.api.response.country.Country
import com.soarmorrow.bms.api.response.country.CountryResponse
import com.soarmorrow.bms.api.response.login.LoginResponse
import com.soarmorrow.bms.api.response.register.RegisterResponse
import com.soarmorrow.bms.api.response.state.State
import com.soarmorrow.bms.api.response.state.StateResponse
import com.soarmorrow.bms.constants.Config
import com.soarmorrow.bms.repository.LoginRepository
import com.soarmorrow.bms.repository.RegisterRepository
import org.koin.standalone.KoinComponent

class RegisterViewModel(private val dataRepository: RegisterRepository) : ViewModel(),
    KoinComponent {

    var registerResponse = MutableLiveData<RegisterResponse>()

    var countryResponse = MutableLiveData<List<Country>>()

    var stateResponse = MutableLiveData<List<State>>()

    var cityResponse = MutableLiveData<List<City>>()

    var registerRequest=RegisterRequest()



    fun doRegister(registerRequest: RegisterRequest) {
        dataRepository.doPropertyOwnerRegister(
           registerRequest,
            object : RegisterRepository.OnRegisterResponse {
                override fun onSuccess(data: RegisterResponse) {
                    registerResponse.value = data
                }

                override fun onFailure() {
                    //REQUEST FAILED
                }
            })
    }

    fun getCountry()
    {
        dataRepository.getCountry(object : RegisterRepository.OnDataResponse {
                override fun onSuccess(data: Any?) {
                    data.let {
                        data as CountryResponse
                        val list= mutableListOf(Country("Select Country"))
                        list.addAll(data.message?.data as List<Country>)
                        countryResponse.value = list

                    }

                }

                override fun onFailure() {
                    //REQUEST FAILED
                }
            })
    }
    fun getState(countryId:String)
    {
        dataRepository.getState(Config.getStateUrl(countryId),object : RegisterRepository.OnDataResponse {
            override fun onSuccess(data: Any?) {
                data.let {
                    data as StateResponse
                    val list= mutableListOf(State("Select State"))
                    list.addAll(data.message?.data as List<State>)
                    stateResponse.value = list

                }
            }

            override fun onFailure() {
                //REQUEST FAILED
            }
        })
    }
    fun getCity(stateId:String)
    {
        dataRepository.getCity(Config.getCityUrl(stateId),object : RegisterRepository.OnDataResponse {
            override fun onSuccess(data: Any?) {
                data.let {
                    data as CityResponse
                    val list= mutableListOf(City("Select City"))
                    list.addAll(data.message?.data as List<City>)
                    cityResponse.value = list

                }
            }

            override fun onFailure() {
                //REQUEST FAILED
            }
        })
    }
}

