package com.jago.atm.state

import com.jago.atm.model.Atm
import com.jago.atm.model.AtmStateType
import com.jago.atm.model.CardInfo
import com.jago.atm.model.User
import com.jago.atm.repo.UserRepo
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class CardReadingState(private val atm: Atm): State {

    @Override
    override fun initiate(userName: String): String {
        throw IllegalStateException("")
    }

    override fun readCard(cardInfo: CardInfo) {
        throw IllegalStateException("")
    }

    override fun withdrawMoney(cardInfo: CardInfo, txnId: String) {
        throw IllegalStateException("")
    }

    override fun depositMoney(user: User, depositAmount: Double)  {
        throw IllegalStateException("")
    }

    override fun transferMoney(fromCard: CardInfo, toCard: CardInfo, txnId: String) {
        throw IllegalStateException("")
    }

    override fun logout() {
        val user = UserRepo.getLogInUser()
        user.updateLoginStatus(false)
        atm.changeState(ReadyState(atm))

        logger.info("Goodbye, {}!", user.userName)
    }

    override fun getStateType(): AtmStateType {
        return AtmStateType.CARD_READING
    }

    companion object {
        private val logger = LoggerFactory.getLogger(CardReadingState::class.java)
    }

}