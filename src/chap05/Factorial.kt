package chap05

import kotlin.jvm.JvmStatic

internal object Factorial {
    fun factorial(n: Int): Int {
        return if (n > 0) n * factorial(n - 1) else 1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("정수를 입력하세요. : ")
        val x = readLine()!!.toInt()
        println(x.toString() + "의 팩토리얼은 " + factorial(x) + "입니다.")
    }
}