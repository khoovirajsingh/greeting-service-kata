package com.katas

import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ApplicationTest {
    @Test
    fun `just a greeting`() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/greeting").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertTrue(predefinedMessagesFor("my friend").contains(response.content))
            }
        }
    }

    @Test
    fun `greeting a user by choosing a random greeting message from a set of messages`() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/greeting/joe").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertTrue(predefinedMessagesFor("Joe").contains(response.content))
            }
        }
    }
}

fun predefinedMessagesFor(user: String): List<String> {
    val hello = "Hello $user!"
    val hey = "Hey $user, nice to see you here!"
    val welcome = "$user welcome back!"
    val splendid = "Have a splendid day $user."
    return listOf(hello, hey, welcome, splendid)
}