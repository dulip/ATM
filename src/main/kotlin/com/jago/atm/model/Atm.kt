package com.jago.atm.model

import com.jago.atm.repo.ATMRepo
import com.jago.atm.service.AtmService
import com.jago.atm.state.State
import org.slf4j.LoggerFactory

enum class AtmStateType(val stateValue: String) {
    READY("ready"),
    CARD_READING("reading"),
    WITHDRAW_INFO_READING("withdraw"),
    DEPOSITING("depositing"),
    CASH_TRANSFERRING("cash_transferring"),
    CARD_EJECTING("ejecting"),
    CANCEL("cancel")
}

class Atm(atmId: Long){

    private val machineId = atmId
    private var stateObj: State? = AtmService.getAtmState(ATMRepo.getStateType(atmId),this)
    private var currentTxnId: String? = null

    /**
     * Login user
     */
    fun login(userName: String): Boolean{
        if (stateObj != null && stateObj!!.getStateType() == AtmStateType.READY){
            currentTxnId = stateObj!!.initiate(userName)
        }else {
            logger.error("ATM Machine {} already processing a transaction", machineId)
            return false
        }

        return true
    }

    fun deposit(userName: String, amount: Double) {
        if (stateObj != null){
            stateObj!!.logout()
        }
    }

    /**
     * Logout user
     */
    fun logout(){
        if (stateObj != null){
            stateObj!!.logout()
        }
    }

    fun handleWithdraw(){
        println("xxxx")
    }

    fun handleTransfer(){
        println("xxxx")
    }

    fun handleDeposit(){
        println("xxxx")
    }

    fun changeState(newState: State){
        stateObj = newState
        ATMRepo.updateState(machineId, newState.getStateType())
    }

    companion object {
        private val logger = LoggerFactory.getLogger(Atm::class.java)
    }
}
