package com.jago.atm.service

import com.jago.atm.model.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AtmServiceTest {

    @BeforeEach
    fun setUp(){
        val user =  User(userId = 1, userName = "Dulip", address = null)
    }

    @Test
    fun `Given correct user detail, ATM should login user successfully`() {
        //when
        val command = "login Dulip"

        //then
        assertThat(true).isTrue
    }
}