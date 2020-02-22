package com.soarmorrow.bms.api.response.city

import com.google.gson.annotations.SerializedName

data class Message(

    @field:SerializedName("data")
	val data: List<City?>? = null,

    @field:SerializedName("text")
	val text: String? = null,

    @field:SerializedName("errors")
	val errors: List<Any?>? = null
)