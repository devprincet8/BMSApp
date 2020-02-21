package com.soarmorrow.bms.api.login

import com.google.gson.annotations.SerializedName

data class User(

	@field:SerializedName("whatsapp")
	val whatsapp: String? = null,

	@field:SerializedName("bank_branch")
	val bankBranch: Any? = null,

	@field:SerializedName("account_number")
	val accountNumber: Any? = null,

	@field:SerializedName("country")
	val country: Country? = null,

	@field:SerializedName("city")
	val city: City? = null,

	@field:SerializedName("roles")
	val roles: List<RolesItem?>? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("land_phone")
	val landPhone: String? = null,

	@field:SerializedName("skype")
	val skype: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("added_by")
	val addedBy: Int? = null,

	@field:SerializedName("account_name")
	val accountName: Any? = null,

	@field:SerializedName("bank_name")
	val bankName: Any? = null,

	@field:SerializedName("commission")
	val commission: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("state_id")
	val stateId: Int? = null,

	@field:SerializedName("is_agent")
	val isAgent: Int? = null,

	@field:SerializedName("state")
	val state: State? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("pincode")
	val pincode: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("is_active")
	val isActive: Int? = null,

	@field:SerializedName("agent_group_id")
	val agentGroupId: Any? = null,

	@field:SerializedName("business")
	val business: Any? = null,

	@field:SerializedName("town")
	val town: String? = null,

	@field:SerializedName("swift_code")
	val swiftCode: Any? = null,

	@field:SerializedName("landphone_code")
	val landphoneCode: String? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null,

	@field:SerializedName("alt_phone")
	val altPhone: Any? = null,

	@field:SerializedName("ifsc_code")
	val ifscCode: Any? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("user_id")
	val userId: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("country_id")
	val countryId: Int? = null,

	@field:SerializedName("city_id")
	val cityId: Int? = null
)