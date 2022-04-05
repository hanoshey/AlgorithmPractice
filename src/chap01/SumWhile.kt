package chap01

import java.util.*
import kotlin.jvm.JvmStatic

internal object SumWhile {
    @JvmStatic
    fun main(args: Array<String>) {
        println("1부터 n까지의 합을 구합니다.")
        println("n의 값: ")
        val n = readLine()!!.toInt()
        var sum = 0
        var i = 1
        while (i <= n) {
            sum += i
            i++
        }
        println("1부터 $n 까지의 합은 $sum 입니다.")
    }
}