package chap03

import kotlin.jvm.JvmStatic

internal class Id {
    val id: Int = ++counter

    companion object {
        var counter = 0 //아이디를 몇 개 부여했는지 저장
            private set
    }
}

object IdTester {
    @JvmStatic
    fun main(args: Array<String>) {
        val a = Id()
        val b = Id()
        println("a의 아이디 : " + a.id)
        println("b의 아이디 : " + b.id)
        println("부여한 아이디의 개수 : " + Id.counter)
    }
}