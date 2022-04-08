package chap02.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 배열 a의 요소의 합을 출력
internal object SumOf_02_03 {
    fun sumOf(a: IntArray): Int {
        var sum = 0
        for (i in a.indices) sum += a[i]
        return sum
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        print("요솟수는：")
        val num = stdIn.nextInt() // 요솟수
        val a = IntArray(num) // 길이가 num인 배열
        for (i in 0 until num) {
            print("a[$i] : ")
            a[i] = stdIn.nextInt()
        }
        println("전 요소의 합계는 " + sumOf(a) + "입니다.")
    }
}