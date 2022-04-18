package chap06.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 셸정렬(버전2：h = …, 40, 13, 4, 1：요소의 옮김 횟수를 카운트)
internal object ShellSortEx2_06_09 {
    // 셸정렬(요소의 옮김 횟수를 반환)
    fun shellSort(a: IntArray, n: Int): Int {
        var count = 0 // 옮김 횟수
        var h: Int
        h = 1
        while (h < n / 9) {
            h = h * 3 + 1
        }
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
            h /= 3
        }
        return count
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        println("셸정렬(버전 2) ")
        print("요솟수：")
        val nx = stdIn.nextInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i]：")
            x[i] = stdIn.nextInt()
        }
        val count = shellSort(x, nx) // 배열 x를 셸정렬
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx) println("x[" + i + "]＝" + x[i])
        println("요소의 옮김횟수는 " + count + "회입니다.")
    }
}