package chap06.answer

import kotlin.jvm.JvmStatic

internal object ShakerSort_06_05 {
    // 배열의 요소 a[idx1]과 a[idx2]를 교환
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    // 양방향 버블정렬(셰이커정렬)
    fun shakerSort(a: IntArray, n: Int) {
        var left = 0
        var right = n - 1
        var last = right
        while (left < right) {
            for (j in right downTo left + 1) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j)
                    last = j
                }
            }
            left = last
            for (j in left until right) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1)
                    last = j
                }
            }
            right = last
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("양방향 버블정렬(셰이커정렬)")
        print("요솟수：")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i]：")
            x[i] = readLine()!!.toInt()
        }
        shakerSort(x, nx) // 배열 x를 양방향 버블정렬
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx) println("x[$i]＝${x[i]}")
    }
}