package com.katas.com.katas

class GreetingService(private val customMessageGenerator: CustomMessageGenerator) {
    fun greet(user: String? = ""): String {
        val name = name(user)
        return customMessageGenerator.generate(name)
    }

    private fun name(user: String?): String {
        if (user.isNullOrEmpty()) return "my friend"
        return user.capitalize()
    }
}
