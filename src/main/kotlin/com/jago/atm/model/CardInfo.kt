package com.jago.atm.model

import java.time.LocalDate

data class CardInfo(
    val cardNumber: String,
    val expireDate: LocalDate,
    val authCode: String,
)
