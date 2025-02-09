package com.jago.atm.model

class Account(
    val accountNumber: String,
    val branch: String? = null,
){
    private var accountBalance: Double = 0.0

    fun depositMoney(depositAmount: Double){
        accountBalance += depositAmount
    }

    fun withdrawMoney(withdrawAmount: Double){
        accountBalance -= withdrawAmount
    }

    fun getBalance(): Double = accountBalance
}


