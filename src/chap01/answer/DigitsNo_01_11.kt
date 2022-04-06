package chap01.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 양의 정수값의 자릿수를 구하여 나타냄
internal object DigitsNo_01_11 {
    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        println("양의 정수값의 자릿수를 구합니다.")
        var n: Int
        do {
            print("정수값：")
            n = stdIn.nextInt()
        } while (n <= 0)
        var no = 0 // 자릿수
        while (n > 0) {
            n /= 10 // n을 10으로 나눔
            no++
        }
        println("그 수는 " + no + "자리입니다.")
    }
}