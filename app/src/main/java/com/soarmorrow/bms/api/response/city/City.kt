package com.soarmorrow.bms.api.response.city

import com.google.gson.annotations.SerializedName

data class City(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("state_id")
	val stateId: Int? = null
)