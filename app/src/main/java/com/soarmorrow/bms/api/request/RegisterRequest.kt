package com.soarmorrow.bms.api.request

data class RegisterRequest(
    var name: String="",
    var email: String="",
    var business: String="",
    var country_id: String="",
    var state_id: String="",
    var city_id: String="",
    var pincode: String="",
    var phone: String="",
    var address: String="",
    var password: String="",
    var skype: String="",
    var whatsapp: String="",
    var land_phone: String="",
    var landphone_code: String="",
    var username: String=""

)
