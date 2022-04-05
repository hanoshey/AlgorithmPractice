package chap01.Answer

import kotlin.jvm.JvmStatic
import java.util.*

// 3개의 값의 최솟값을 구하여 출력
internal object Min3_01_02 {
    // a, b, c의 최솟값을 구하여 반환
    fun min3(a: Int, b: Int, c: Int): Int {
        var min = a // 최솟값
        if (b < min) min = b
        if (c < min) min = c
        return min
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        val a: Int
        val b: Int
        val c: Int
        println("세 정수의 최솟값을 구합니다.")
        print("a의 값：")
        a = stdIn.nextInt()
        print("b의 값：")
        b = stdIn.nextInt()
        print("c의 값：")
        c = stdIn.nextInt()
        val min = min3(a, b, c) // a, b, c의 최솟값
        println("최솟값은 " + min + "입니다.")
    }
}