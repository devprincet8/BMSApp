package com.soarmorrow.bms.api.response.register

import com.google.gson.annotations.SerializedName

data class Message(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("errors")
	val errors: Errors? = null
)