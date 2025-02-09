package com.jago.atm.model

enum class TransactionType(val txnType: String) {
    DEPOSIT("deposit"),
    WITHDRAW("withdraw"),
    TRANSFER("transfer"),
}

enum class TransactionState(){
    APPROVE,
    REJECT,
    PROCESSING,
    CANCEL
}

data class Transaction(
    val txnId: String,
    val txnType:TransactionType? = null,
    val amount: Double? = null,
    val txnState: TransactionState? = null,
    val sender: String? = null,
    val receiver: String? = null,
)