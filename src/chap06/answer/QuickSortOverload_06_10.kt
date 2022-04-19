package chap06.answer

import kotlin.jvm.JvmStatic

internal object QuickSortOverload_06_10 {
    // 배열의 요소 a[idx1]과 a[idx2]를 교환
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    // 퀵정렬(left, right … 머리&꼬리요소의 index)
    fun quickSort(a: IntArray, left: Int, right: Int) {
        var pl = left // 왼쪽 커서
        var pr = right // 오른쪽 커서
        val x = a[(pl + pr) / 2] // 피벗 (중앙의 요소)
        do {
            while (a[pl] < x) pl++
            while (a[pr] > x) pr--
            if (pl <= pr) swap(a, pl++, pr--)
        } while (pl <= pr)
        if (left < pr) quickSort(a, left, pr)
        if (pl < right) quickSort(a, pl, right)
    }

    // 퀵정렬(n … 요솟수)
    fun quickSort(a: IntArray, n: Int) {
        quickSort(a, 0, n - 1)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("퀵정렬 ")
        print("요솟수：")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i]：")
            x[i] = readLine()!!.toInt()
        }
        quickSort(x, nx) // 배열 x를 퀵정렬
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx) println("x[$i]＝${x[i]}")
    }
}