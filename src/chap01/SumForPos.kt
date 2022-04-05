package chap01

import java.util.*
import kotlin.jvm.JvmStatic

internal object SumForPos {
    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        var n: Int
        println("1부터 n까지의 합을 구합니다.")
        do {
            print("n의 값: ")
            n = stdIn.nextInt()
        } while (n <= 0)
        var sum = 0
        for (i in 1..n) sum += i
        println("1부터 " + n + "까지의 합은 " + sum + "입니다.")
    }
}