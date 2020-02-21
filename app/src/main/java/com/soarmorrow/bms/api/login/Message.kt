package com.soarmorrow.bms.api.login

import com.google.gson.annotations.SerializedName

data class Message(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("errors")
	val errors: Errors? = null,

	@field:SerializedName("token")
	val token: String? = null
)