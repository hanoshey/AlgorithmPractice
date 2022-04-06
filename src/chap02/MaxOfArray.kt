package chap02

import kotlin.jvm.JvmStatic

internal object MaxOfArray {
    private fun maxOf(a: kotlin.IntArray): Int {
        var max: Int = a[0]
        for (i in 1 until a.size) if (a[i] > max) max = a[i]
        return max
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("키의 최댓값을 구합니다.")
        print("사람 수: ")
        val num = readLine()!!.toInt()
        val height = IntArray(num)
        for (i in 0 until num) {
            print("height[$i] : ")
            height[i] = readLine()!!.toInt()
        }
        println("최댓값은 ${maxOf(height)}입니다.")
    }
}