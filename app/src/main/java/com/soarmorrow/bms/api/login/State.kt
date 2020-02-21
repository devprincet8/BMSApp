package com.soarmorrow.bms.api.login

import com.google.gson.annotations.SerializedName

data class State(

	@field:SerializedName("updated_at")
	val updatedAt: Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("country_id")
	val countryId: Int? = null
)