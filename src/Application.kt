package com.katas

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.features.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {
        get("/greeting") {
            call.respondText("Hello my friend!", contentType = ContentType.Text.Plain)
        }
        get("/greeting/{user}") {
            val user = call.parameters["user"] ?: "my friend"
            call.respondText("Hello ${user.capitalize()}!", contentType = ContentType.Text.Plain)
        }

        install(StatusPages) {
            exception<AuthenticationException> { cause ->
                call.respond(HttpStatusCode.Unauthorized)
            }
        }
    }
}

class AuthenticationException : RuntimeException()

