package chap06.answer

import kotlin.jvm.JvmStatic

internal object BubbleSortR_06_01 {
    // 배열의 요소 a[idx1]과 a[idx2]를 교환
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    // 단순교환정렬
    fun bubbleSort(a: IntArray, n: Int) {
        for (i in n - 1 downTo 1) {
            for (j in 0 until i)  // 머리→꼬리로로 스캔
                if (a[j] > a[j + 1]) swap(a, j, j + 1)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("단순교환정렬(버블정렬)")
        print("요솟수：")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i]：")
            x[i] = readLine()!!.toInt()
        }
        bubbleSort(x, nx) // 배열 x를 단순교환정렬
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx) println("x[$i]＝${x[i]}")
    }
}