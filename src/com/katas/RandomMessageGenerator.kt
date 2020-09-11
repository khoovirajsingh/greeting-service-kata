package com.katas.com.katas

class RandomMessageGenerator : CustomMessageGenerator {
    override fun generate(user: String): String {
        val hello = "Hello $user!"
        val hey = "Hey $user, nice to see you here!"
        val welcome = "$user welcome back!"
        val splendid = "Have a splendid day $user."
        return listOf(hello, hey, welcome, splendid).random()
    }
}