package com.soarmorrow.bms.api.login

import com.google.gson.annotations.SerializedName

data class RolesItem(

	@field:SerializedName("role")
	val role: Role? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("role_id")
	val roleId: Int? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)