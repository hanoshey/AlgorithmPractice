package chap01.Answer

import kotlin.jvm.JvmStatic
import java.util.*

// 정사각형 모양을 나타냄
object Square_01_14 {
    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        var n: Int
        println("정사각형 모양으로 나타냅니다.")
        do {
            print("단수는：")
            n = stdIn.nextInt()
        } while (n <= 0)
        for (i in 1..n) {
            for (j in 1..n) print('*')
            println()
        }
    }
}