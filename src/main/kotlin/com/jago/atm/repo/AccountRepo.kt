package com.jago.atm.repo

import com.jago.atm.model.Account
import com.jago.atm.model.User
import org.slf4j.LoggerFactory
import java.util.UUID

class AccountRepo {
    companion object{
        private val logger = LoggerFactory.getLogger(AccountRepo::class.java)
        private val accountMap = mutableMapOf<String, Account>()

        fun getUserAccount(user: User): Account {
            var account = accountMap[user.userName]
            if (account == null){
                account = initiateNewAccount(user.userName)
            }
            return account
        }

        /**
         * create new account and assign to the given user
         */
        private fun initiateNewAccount(userName: String): Account {
            val account = Account(
                accountNumber = UUID.randomUUID().toString(),
                branch = "Bedok")
            accountMap[userName] = account
            logger.info("Generate new account for user : {} with accountId : {}", userName, account.accountNumber)
            return account
        }
    }
}