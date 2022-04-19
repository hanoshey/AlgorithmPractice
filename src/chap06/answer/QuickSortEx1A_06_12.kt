package chap06.answer

import kotlin.jvm.JvmStatic

internal object QuickSortEx1A_06_12 {
    // 배열의 요소 a[idx1]과 a[idx2]를 교환
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    // 배열을 나눔
    fun quickSort(a: IntArray, left: Int, right: Int) {
        var left = left
        var right = right
        var pl = left // 왼쪽 커서
        var pr = right // 오른쪽 커서
        val x = a[(pl + pr) / 2] // 피벗 (중앙의 요소)
        do {
            while (a[pl] < x) pl++
            while (a[pr] > x) pr--
            if (pl <= pr) swap(a, pl++, pr--)
        } while (pl <= pr)
        if (pr - left < right - pl) {
            var temp: Int
            temp = left
            left = pl
            pl = temp
            temp = right
            right = pr
            pr = temp
        }
        if (left < pr) quickSort(a, left, pr)
        if (pl < right) quickSort(a, pl, right)
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
        quickSort(x, 0, nx - 1) // 배열 x를 퀵정렬
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx) println("x[$i]＝${x[i]}")
    }
}