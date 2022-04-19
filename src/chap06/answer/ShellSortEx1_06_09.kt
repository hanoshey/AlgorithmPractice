package chap06.answer

import kotlin.jvm.JvmStatic

// 셸정렬 버전1 (요소의 옮김 횟수를 반환)
internal object ShellSortEx1_06_09 {
    fun shellSort(a: IntArray, n: Int): Int {
        var count = 0 // 옮김횟수
        var h = n / 2
        while (h > 0) {
            for (i in h until n) {
                var j: Int
                val tmp = a[i]
                j = i - h
                while (j >= 0 && a[j] > tmp) {
                    a[j + h] = a[j]
                    count++
                    j -= h
                }
                a[j + h] = tmp
                count++
            }
            h /= 2
        }
        return count
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("셸정렬(버전 1)")
        print("요솟수：")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i]：")
            x[i] = readLine()!!.toInt()
        }
        val count = shellSort(x, nx) // 배열 x를 셸정렬
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx) println("x[$i]＝${x[i]}")
        println("요소의 옮김횟수는 ${count}회입니다.")
    }
}