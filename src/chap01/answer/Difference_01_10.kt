package chap01.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 정수 b에서 정수 a를 뺀 값을 구합니다(b > a가 되도록 입력 받음)
internal object Difference_01_10 {
    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        print("a의 값：")
        val a = stdIn.nextInt()
        var b = 0
        while (true) {
            print("b의 값：")
            b = stdIn.nextInt()
            if (b > a) break
            println("a보다 큰 값을 입력하세요!")
        }
        println("b - a는 " + (b - a) + "입니다.")
    }
}