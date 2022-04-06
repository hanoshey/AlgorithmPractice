package chap01.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 4개의 값의 최솟값을 구하여 출력
internal object Min4_01_03 {
    // a, b, c, d의 최솟값을 구하여 반환
    fun min4(a: Int, b: Int, c: Int, d: Int): Int {
        var min = a // 최솟값
        if (b < min) min = b
        if (c < min) min = c
        if (d < min) min = d
        return min
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        println("네 정수의 최솟값을 구합니다.")
        print("a의 값：")
        val a: Int = stdIn.nextInt()
        print("b의 값：")
        val b: Int = stdIn.nextInt()
        print("c의 값：")
        val c: Int = stdIn.nextInt()
        print("d의 값：")
        val d: Int = stdIn.nextInt()
        val min = min4(a, b, c, d) // a, b, c, d의 최솟값
        println("최솟값은 " + min + "입니다.")
    }
}