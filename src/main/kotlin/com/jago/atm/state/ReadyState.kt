package com.jago.atm.state

import com.jago.atm.model.Atm
import com.jago.atm.model.AtmStateType
import com.jago.atm.model.CardInfo
import com.jago.atm.model.User
import com.jago.atm.repo.AccountRepo
import com.jago.atm.repo.TransactionRepo
import com.jago.atm.repo.UserRepo
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class ReadyState(private val atm: Atm) : State {

    @Override
    override fun initiate(userName: String): String {
        val user = UserRepo.getUser(userName)
        if (user.isLogIn()){
            logger.info("User {} already logged in", userName)
        }
        user.updateLoginStatus(true)
        val account = AccountRepo.getUserAccount(user)

        logger.info("Hello, {}: ", user.userName)
        logger.info("Your account balance is {}", account.getBalance())

        val txn = TransactionRepo.generateTransaction()
        atm.changeState(CardReadingState(atm))
        return txn.txnId
    }

    override fun readCard(cardInfo: CardInfo) {
        throw IllegalStateException("Currently in ready state, can't read card");
    }

    override fun withdrawMoney(cardInfo: CardInfo, txnId: String) {
        throw IllegalStateException("Currently in use at ready state, can't withdraw money");
    }

    override fun depositMoney(user: User, depositAmount: Double)  {
        throw IllegalStateException("Currently in use at ready state, can't deposit money");
    }

    override fun transferMoney(fromCard: CardInfo, toCard: CardInfo, txnId: String) {
        throw IllegalStateException("Currently in use at ready state, can't transfer money");
    }

    override fun logout() {
        val user = UserRepo.getLogInUser()
        user.updateLoginStatus(false)
        atm.changeState(ReadyState(atm))

        logger.info("Goodbye, {}!", user.userName)
    }

    override fun getStateType(): AtmStateType {
        return AtmStateType.READY
    }

    companion object {
        private val logger = LoggerFactory.getLogger(ReadyState::class.java)
    }
}