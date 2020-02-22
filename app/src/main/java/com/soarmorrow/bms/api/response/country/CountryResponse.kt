package com.soarmorrow.bms.api.response.country

import com.google.gson.annotations.SerializedName

data class CountryResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("message")
	val message: Message? = null
)