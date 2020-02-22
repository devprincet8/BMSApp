package com.soarmorrow.bms.api.request

data class RegisterRequest(
    val nameOfBusiness: String,
    val address1: String,
    val address2: String,
    val city: String,
    val telephone: String,
    val boomingManagerMobile: String,
    val keyContactPersonMobile: String,
    val username: String,
    val email: String,
    val password: String
)