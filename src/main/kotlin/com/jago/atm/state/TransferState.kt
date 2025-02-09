package com.jago.atm.state

import com.jago.atm.model.Atm
import com.jago.atm.model.AtmStateType
import com.jago.atm.model.CardInfo
import com.jago.atm.model.User
import com.jago.atm.repo.UserRepo
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class TransferState(private val atm: Atm): State {
    @Override
    override fun initiate(userName: String): String {
        TODO("Not yet implemented")
    }

    override fun readCard(cardInfo: CardInfo) {
        TODO("Not yet implemented")
    }

    override fun withdrawMoney(cardInfo: CardInfo, txnId: String) {
        TODO("Not yet implemented")
    }

    override fun depositMoney(user: User, depositAmount: Double)  {
        TODO("Not yet implemented")
    }

    override fun transferMoney(fromCard: CardInfo, toCard: CardInfo, txnId: String) {
        TODO("Not yet implemented")
    }

    override fun logout() {
        val user = UserRepo.getLogInUser()
        user.updateLoginStatus(false)
        atm.changeState(ReadyState(atm))

        logger.info("Goodbye, {}!", user.userName)
    }

    override fun getStateType(): AtmStateType {
        return AtmStateType.CASH_TRANSFERRING
    }

    companion object {
        private val logger = LoggerFactory.getLogger(TransferState::class.java)
    }
}