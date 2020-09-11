package com.katas

import com.katas.com.katas.CustomMessageGenerator
import com.katas.com.katas.GreetingService
import org.junit.Test
import kotlin.test.assertEquals

const val JOE = "joe"

class GreetingServiceShould {
    @Test
    fun `greet a user with a random message`() {
        val greetingService = GreetingService(StubbedCustomMessageGenerator())

        val message = greetingService.greet(JOE)

        assertEquals("Joe welcome back!", message)
    }
}

class StubbedCustomMessageGenerator: CustomMessageGenerator {
    override fun generate(user: String): String {
        return "$user welcome back!"
    }
}