package com.katas

import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testGreeting() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/greeting").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello my friend!", response.content)
            }

            handleRequest(HttpMethod.Get, "/greeting/joe").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello Joe!", response.content)
            }
        }
    }
}
