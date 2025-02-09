package com.jago.atm.state

import com.jago.atm.model.AtmStateType
import com.jago.atm.model.CardInfo
import com.jago.atm.model.User

interface State {
    fun initiate(userName: String): String
    fun readCard(cardInfo: CardInfo)
    fun withdrawMoney(cardInfo: CardInfo, txnId: String)
    fun depositMoney(user: User, depositAmount: Double)
    fun transferMoney(fromCard: CardInfo, toCard: CardInfo, txnId: String)
    fun logout()
    fun getStateType(): AtmStateType
}