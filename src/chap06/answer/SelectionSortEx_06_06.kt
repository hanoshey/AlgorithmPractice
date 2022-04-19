package chap06.answer

import kotlin.jvm.JvmStatic

internal object SelectionSortEx_06_06 {
    // 배열의 요소 a[idx1]과 a[idx2]를 교환
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    // 단순선택정렬
    fun selectionSort(a: IntArray, n: Int) {
        for (i in 0 until n - 1) {
            var min = i // 미정렬된 부분 최소 요소의 index
            for (j in i + 1 until n) if (a[j] < a[min]) min = j
            for (m in 0 until n) print(if (m == i) "  * " else if (m == min) "  + " else "    ")
            println()
            for (m in 0 until n) System.out.printf("%3d ", a[m])
            println("\n")
            swap(a, i, min) // 미정렬된 부분 머리요소와 최소 요소를 교환
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("단순선택정렬")
        print("요솟수：")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i]：")
            x[i] = readLine()!!.toInt()
        }
        selectionSort(x, nx) // 배열 x를 단순선택정렬
    }
}