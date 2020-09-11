package com.katas

import com.katas.com.katas.GreetingService
import org.junit.Test
import kotlin.test.assertEquals

const val ANONYMOUS_USER = ""
const val JOE = "joe"

class GreetingServiceShould {
    @Test
    fun `greet an anonymous user`() {
        val greetingService = GreetingService()

        val message = greetingService.greet(ANONYMOUS_USER)

        assertEquals("Hello my friend!", message);
    }

    @Test
    fun `greet a known user`() {
        val greetingService = GreetingService()

        val message = greetingService.greet(JOE)

        assertEquals("Hello Joe!", message);
    }
}