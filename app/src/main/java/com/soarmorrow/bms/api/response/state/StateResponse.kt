package com.soarmorrow.bms.api.response.state

import com.google.gson.annotations.SerializedName

data class StateResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("message")
	val message: Message? = null
)