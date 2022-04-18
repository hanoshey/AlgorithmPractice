package chap06.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 퀵정렬(임의로 추출한 ３요소의 중앙값을 피벗으로 합니다. : 비재귀버전)
internal object QuickSortEx3B_06_14 {
    // a, b, c의 중앙값을 구하여 반환
    fun med3(a: Int, b: Int, c: Int): Int {
        return if (a >= b) if (b >= c) b else if (a <= c) a else c else if (a > c) a else if (b > c) c else b
    }

    // 배열의 요소 a[idx1]과 a[idx2]를 교환
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
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

    // 퀵정렬(비재귀버전)
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
                val x = med3(a[pl], a[(pl + pr) / 2], a[pr])
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
        val stdIn = Scanner(System.`in`)
        println("퀵정렬 ")
        print("요솟수：")
        val nx = stdIn.nextInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i]：")
            x[i] = stdIn.nextInt()
        }
        quickSort(x, 0, nx - 1) // 배열 x를 퀵정렬
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx) println("x[" + i + "] = " + x[i])
    }
}