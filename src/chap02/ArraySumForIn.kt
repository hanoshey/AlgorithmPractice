package chap02

import kotlin.jvm.JvmStatic

internal object ArraySumForIn {
    @JvmStatic
    fun main(args: Array<String>) {
        val a = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0)
        for (i in a.indices) println("a[" + i + "] = " + a[i])
        var sum = 0.0
        for (i in a) sum += i
        println("모든 요소의 합은 " + sum + "입니다.")
    }
}