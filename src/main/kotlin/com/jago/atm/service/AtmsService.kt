package com.jago.atm.service

import com.jago.atm.model.Atm
import com.jago.atm.model.AtmStateType
import com.jago.atm.state.*
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import java.io.BufferedReader
import java.io.InputStreamReader
import java.security.InvalidParameterException

enum class AtmActionType(val action: String) {
    LOGIN("login"),
    WITHDRAW("withdraw"),
    DEPOSIT("deposit"),
    TRANSFER("transfer"),
    LOGOUT("logout"),
}

@Service
class AtmService : CommandLineRunner {
    override fun run(vararg args: String?) {
        logger.info("Welcome to Jago ATM application!!")

        val reader =  BufferedReader(InputStreamReader(System.`in`))
        while (true){
            val inputLine = reader.readLine() ?: break
            val values = inputLine.trim().split("\\s+".toRegex())
            if (values.isEmpty()) continue
            logger.info(inputLine)
            val inputParameter = if(values.size > 1) values[1] else null
            when (values.first()){
                AtmActionType.LOGIN.action -> handleLogin(inputParameter)
                AtmActionType.WITHDRAW.action -> handleWithdraw()
                AtmActionType.DEPOSIT.action -> handleDeposit()
                AtmActionType.TRANSFER.action -> handleTransfer()
                AtmActionType.LOGOUT.action -> handleLogout()
                else -> println("Invalid command : ${values.first()}")
            }
        }
    }

    /**
     * Predefined machineId and randomly generate within the given range
     * In the real world example machineId need to validate
     */
    fun handleLogin(userName: String?){
        if (userName == null) {
            throw InvalidParameterException("Invalid login information")
        }

        //login proceed
        val machineId = 1000L
        val atm = Atm(machineId)
        atm.login(userName)
    }

    fun handleLogout(){
        val machineId = 1000L

        val atm = Atm(machineId)
        atm.logout()
    }

    fun handleDeposit(){
        val machineId = 1000L

        val atm = Atm(machineId)
        atm.logout()
    }

    companion object {
        private val logger = LoggerFactory.getLogger(AtmService::class.java)

        /**
         * @Input state: ATM state
         * @Input atm : ATM object
         * @Output return Matching State object based on the state value
         */
        fun getAtmState(state: AtmStateType?, atm: Atm): State?{
            return when (state){
                AtmStateType.READY -> ReadyState(atm)
                AtmStateType.CARD_READING -> CardReadingState(atm)
                AtmStateType.CARD_EJECTING -> CardEjectingState(atm)
                AtmStateType.CASH_TRANSFERRING -> TransferState(atm)
                AtmStateType.DEPOSITING -> DepositState(atm)
                AtmStateType.WITHDRAW_INFO_READING -> WithdrawMoneyState(atm)
                else -> {
                    logger.error("Not supported state {}!", state)
                    null
                }
            }
        }
    }

    fun handleWithdraw(){
        println("xxxx")
    }

    fun handleTransfer(){
        println("xxxx")
    }
}