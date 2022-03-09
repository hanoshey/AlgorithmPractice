package chap01

import java.util.*
import kotlin.jvm.JvmStatic

    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        println("세 정수의 최댓값을 구합니다.")
        print("a의 값 :")
        val a = stdIn.nextInt()
        print("b의 값 :")
        val b = stdIn.nextInt()
        print("c의 값 :")
        val c = stdIn.nextInt()
        var max = a
        if (b > max) max = b
        if (c > max) max = c
        println("최댓값은 " + max + "입니다.")
    }
