package com.jago.atm.repo

import com.jago.atm.model.CardInfo
import com.jago.atm.model.User
import org.slf4j.LoggerFactory
import java.time.LocalDate

class UserRepo {

    companion object {
        private val logger = LoggerFactory.getLogger(UserRepo::class.java)
        private val userMap = mutableMapOf<String, User>()

        /**
         * Retrieve user
         */
        fun getUser(name: String): User {
            var user = userMap[name]
            if (user == null){
                user = initiateNewUser(name)
            }
            return user
        }

        /**
         * Retrieve logged in user
         */
        fun getLogInUser(): User {
            return userMap.values.filter { it.isLogIn() }.first()
        }

        /**
         * create new user
         * Card info use mock values
         */
        private fun initiateNewUser(userName: String): User {
            val cardInfo = CardInfo("123456", LocalDate.now(),"333")
            val user = User((1..100000).random().toLong(), userName, null, mutableListOf(cardInfo) )
            userMap[userName] = user
            logger.info("Generate new user with name : {}", userName)
            return user
        }

    }
}