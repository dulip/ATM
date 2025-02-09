package com.jago.atm.repo

import com.jago.atm.model.AtmStateType
import com.jago.atm.model.Transaction
import java.util.UUID

class TransactionRepo {
    companion object {
        private val transactionMap = mutableMapOf<String, List<Transaction>>()

        /**
         * insert transaction
         */
        fun generateTransaction(): Transaction{
            val txn =  Transaction(UUID.randomUUID().toString())
            transactionMap[txn.txnId] =
            return txn
        }
    }
}