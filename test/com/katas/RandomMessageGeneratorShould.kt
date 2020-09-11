package com.katas

import com.katas.com.katas.RandomMessageGenerator
import org.junit.Assert.assertTrue
import org.junit.Test

class RandomMessageGeneratorShould {
    @Test
    fun `generate a random message`() {
        val randomMessageGenerator = RandomMessageGenerator()

        val message = randomMessageGenerator.generate(JOE)

        assertTrue(predefinedMessagesFor(JOE).contains(message))
    }
}