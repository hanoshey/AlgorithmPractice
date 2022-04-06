package chap01.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 네 값의 최댓값을 구하여 나타냄
internal object Max4_01_01 {
    // a, b, c, d의 최댓값을 구하여 반환
    fun max4(a: Int, b: Int, c: Int, d: Int): Int {
        var max = a // 최댓값
        if (b > max) max = b
        if (c > max) max = c
        if (d > max) max = d
        return max
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        println("네 정수의 최댓값을 구합니다.")
        print("a의 값：")
        val a: Int = stdIn.nextInt()
        print("b의 값：")
        val b: Int = stdIn.nextInt()
        print("c의 값：")
        val c: Int = stdIn.nextInt()
        print("d의 값：")
        val d: Int = stdIn.nextInt()
        val max = max4(a, b, c, d) // a, b, c, d의 최댓값
        println("최댓값은 " + max + "입니다.")
    }
}