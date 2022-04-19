package chap06.answer

import kotlin.jvm.JvmStatic

internal object InsertionSortCen_06_07 {
    // 단순삽입정렬(보초법：배열의 머리요소는 비어있습니다.)
    fun insertionSort(a: IntArray, n: Int) {
        for (i in 2 until n) {
            a[0] = a[i]
            val tmp = a[0]
            var j = i
            while (a[j - 1] > tmp) {
                a[j] = a[j - 1]
                j--
            }
            if (j > 0) a[j] = tmp
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("단순삽입정렬 ")
        print("요솟수：")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx + 1) // 1개 여분으로 생성
        for (i in 1..nx) { // x[1]~x[nx]에 읽어 들임
            print("x[$i]：")
            x[i] = readLine()!!.toInt()
        }
        insertionSort(x, nx + 1) // 배열 x를 단순삽입정렬
        println("오름차순으로 정렬했습니다.")
        for (i in 1..nx) println("x[$i]＝${x[i]}")
    }
}