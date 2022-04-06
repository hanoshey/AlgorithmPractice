package chap01.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 정수a, b를 포함하여 그 사이의 모든 정수의 합을 구합니다. 
internal object SumOf_01_09 {
    fun sumof(a: Int, b: Int): Int {
        val min: Int // a, b의 작은 쪽의 값
        val max: Int // a, b의 큰 쪽의 값
        if (a < b) {
            min = a
            max = b
        } else {
            min = b
            max = a
        }
        var sum = 0 // 합
        for (i in min..max) sum += i
        return sum
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        println("a와 b를 포함하여 그 사이의 모든 정수의 합을 구합니다.")
        print("a의 값：")
        val a = stdIn.nextInt()
        print("b의 값：")
        val b = stdIn.nextInt()
        println("정수 a, b 사이의 모든 정수의 합은 " + sumof(a, b) + "입니다.")
    }
}