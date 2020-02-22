package com.soarmorrow.bms.constants

object Config {
    const val BASE_URL="https://demo.soarmorrow.com/bms/public/api/"
    const val SUCCESS=200

    fun getStateUrl(id:String):String
    {
        return BASE_URL +"get-states?country_id="+id
    }
    fun getCityUrl(id:String):String
    {
        return BASE_URL +"get-cities?state_id="+id
    }
}