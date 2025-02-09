package com.jago.atm.repo

import com.jago.atm.model.AtmStateType
import org.slf4j.LoggerFactory

class ATMRepo {
    companion object {
        private val logger = LoggerFactory.getLogger(ATMRepo::class.java)
        private val ATMS = mutableListOf(1000L, 1001L, 1002L, 1003L)
        private val stateMap = mutableMapOf(
            1000L to AtmStateType.READY,
            1001L to AtmStateType.READY,
            1002L to AtmStateType.READY,
            1003L to AtmStateType.READY
        )

        fun getStateType(machineId: Long?): AtmStateType?{
            return if (machineId == null) {
                logger.error("Invalid ATM Id")
                return null
            } else {
                stateMap[machineId]
            }
        }

        /**
         * Update current state type of ATM
         */
        fun updateState(machineId: Long, newState: AtmStateType){
            stateMap[machineId] = newState
            logger.info("ATM Machine {} is on new state {}", machineId, newState.name)
        }

    }
}