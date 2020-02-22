package com.soarmorrow.bms.api.response.register

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("whatsapp")
	val whatsapp: String? = null,

	@field:SerializedName("pincode")
	val pincode: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("business")
	val business: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("landphone_code")
	val landphoneCode: String? = null,

	@field:SerializedName("land_phone")
	val landPhone: String? = null,

	@field:SerializedName("skype")
	val skype: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("commission")
	val commission: Int? = null,

	@field:SerializedName("is_agent")
	val isAgent: Int? = null,

	@field:SerializedName("state_id")
	val stateId: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("country_id")
	val countryId: String? = null,

	@field:SerializedName("city_id")
	val cityId: String? = null
)