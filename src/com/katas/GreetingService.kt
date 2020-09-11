package com.katas.com.katas

class GreetingService {
    fun greet(user: String? = ""): String {
        return "Hello ${name(user)}!"
    }

    private fun name(user: String?): String {
        if (user.isNullOrEmpty()) return "my friend"
        return user.capitalize()
    }
}
