package chap06

import java.util.Arrays

internal object ArraysSortTester {
    @JvmStatic
    fun main(args: Array<String>) {
        print("요솟수: ")
        val num = readLine()!!.toInt()
        val x = IntArray(num)
        for (i in 0 until num) {
            print("x[$i] :")
            x[i] = readLine()!!.toInt()
        }
        Arrays.sort(x)
        println("오름차순으로 정렬합니다.")
        for (i in 0 until num)
            println("x[$i]=${x[i]}")
    }
}