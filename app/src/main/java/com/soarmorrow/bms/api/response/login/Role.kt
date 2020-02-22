package com.soarmorrow.bms.api.response.login

import com.google.gson.annotations.SerializedName

data class Role(

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("display_name")
	val displayName: String? = null
)