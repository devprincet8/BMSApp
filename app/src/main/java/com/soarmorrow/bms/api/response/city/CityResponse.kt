package com.soarmorrow.bms.api.response.city

import com.google.gson.annotations.SerializedName

data class CityResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("message")
	val message: Message? = null
)