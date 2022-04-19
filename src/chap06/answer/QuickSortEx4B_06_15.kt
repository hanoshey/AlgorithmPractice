package chap06.answer

import kotlin.jvm.JvmStatic

// 퀵정렬(머리/중앙/꼬리요소를 정렬하여 중앙값을 피벗으로 합니다. : 비재귀버전)
internal object QuickSortEx4B_06_15 {
    // 배열의 요소 a[idx1]과 a[idx2]를 교환
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    // x[a], x[b], x[c]를 sort (중앙값의 index를 반환)
    fun sort3Elem(x: IntArray, a: Int, b: Int, c: Int): Int {
        if (x[b] < x[a]) swap(x, b, a)
        if (x[c] < x[b]) swap(x, c, b)
        if (x[b] < x[a]) swap(x, b, a)
        return b
    }

    // 단순삽입정렬
    fun insertionSort(a: IntArray, left: Int, right: Int) {
        for (i in left + 1..right) {
            val tmp = a[i]
            var j: Int
            j = i
            while (j > 0 && a[j - 1] > tmp) {
                a[j] = a[j - 1]
                j--
            }
            a[j] = tmp
        }
    }

    // 퀵정렬 (비재귀버전)
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
            if (right - left < 9) insertionSort(a, left, right) else {
                var x: Int // 피벗
                val m = sort3Elem(a, pl, (pl + pr) / 2, pr)
                x = a[m]
                swap(a, m, right - 1)
                pl++
                pr--
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