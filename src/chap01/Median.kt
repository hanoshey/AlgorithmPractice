package chap01

import kotlin.jvm.JvmStatic
import chap01.Median
import java.util.*

object Median {
    private fun med3(a: Int, b: Int, c: Int): Int {
        return if (a >= b) if (b >= c) b else if (a <= c) a else c else if (a > c) a else if (b > c) c else b
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        println("세 정수의 중앙값을 구합니다.")
        print("a의 값 : ")
        val a = stdIn.nextInt()
        print("b의 값 : ")
        val b = stdIn.nextInt()
        print("c의 값 : ")
        val c = stdIn.nextInt()
        println("중앙값은 " + med3(a, b, c) + "입니다.")
    }
}