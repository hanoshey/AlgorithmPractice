package chap06.answer

import kotlin.jvm.JvmStatic

internal object QuickSortEx1B_06_12 {
    // 배열의 요소 a[idx1]과 a[idx2]를 교환
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    // 퀵정렬
    fun quickSort(a: IntArray, left: Int, right: Int) {
        var left = left
        var right = right
        val lstack = IntStack(right - left + 1)
        val rstack = IntStack(right - left + 1)
        lstack.push(left)
        rstack.push(right)
        while (lstack.isEmpty != true) {
            left = lstack.pop()
            var pl = left // 왼쪽 커서
            right = rstack.pop()
            var pr = right // 오른쪽 커서
            val x = a[(left + right) / 2] // 피벗은 중앙의 요소
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
            if (left < pr) {
                lstack.push(left)
                rstack.push(pr)
            }
            if (pl < right) {
                lstack.push(pl)
                rstack.push(right)
            }
        }
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
        for (i in 0 until nx) println("x[$i] = ${x[i]}")
    }
}