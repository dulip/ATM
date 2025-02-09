package com.jago.atm.model

class User(
    val userId: Long,
    val userName: String,
    val address: Address? = null,
    val cards: List<CardInfo>? = null
){
    private var isLoggedIntoAtm =  false

    fun isLogIn(): Boolean{
        return isLoggedIntoAtm
    }

    fun updateLoginStatus(loginStatus: Boolean) {
        isLoggedIntoAtm = loginStatus
    }
}

data class Address(
    val postalCode:String? = null,
    val addressLine1: String? = null,
    val addressLine2: String? = null,
    val province: String? = null
)


