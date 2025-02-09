package com.jago.atm.state

import com.jago.atm.model.Atm
import com.jago.atm.model.AtmStateType
import com.jago.atm.model.CardInfo
import com.jago.atm.model.User
import com.jago.atm.repo.UserRepo
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class WithdrawMoneyState(private val atm: Atm) : State {

    @Override
    override fun initiate(userName: String): String {
        TODO("Not yet implemented")
    }

    override fun readCard(cardInfo: CardInfo) {
        TODO("Not yet implemented")
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
        return AtmStateType.WITHDRAW_INFO_READING
    }

    companion object {
        private val logger = LoggerFactory.getLogger(WithdrawMoneyState::class.java)
    }
}