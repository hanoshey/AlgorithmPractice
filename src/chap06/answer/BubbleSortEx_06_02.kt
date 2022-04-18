package chap06.answer

import kotlin.jvm.JvmStatic
import java.util.*

internal object BubbleSortEx_06_02 {
    // 배열의 요소 a[idx1]과 a[idx2]를 교환
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    // 단순교환정렬
    fun bubbleSort(a: IntArray, n: Int) {
        var ccnt = 0 // 비교횟수
        var scnt = 0 // 교환횟수
        for (i in 0 until n - 1) {
            System.out.printf("패스%d：\n", i + 1)
            for (j in n - 1 downTo i + 1) {
                for (m in 0 until n - 1) System.out.printf(
                    "%3d %c",
                    a[m],
                    if (m != j - 1) ' ' else if (a[j - 1] > a[j]) '+' else '-'
                )
                System.out.printf("%3d\n", a[n - 1])
                ccnt++
                if (a[j - 1] > a[j]) {
                    scnt++
                    swap(a, j - 1, j)
                }
            }
            for (m in 0 until n) System.out.printf("%3d  ", a[m])
            println()
        }
        println("비교를 " + ccnt + "회 했습니다.")
        println("교환를 " + scnt + "회 했습니다.")
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        println("단순교환정렬  (버블정렬)")
        print("요솟수：")
        val nx = stdIn.nextInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i]：")
            x[i] = stdIn.nextInt()
        }
        bubbleSort(x, nx) // 배열 x를 단순교환정렬
    }
}