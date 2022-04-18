package chap06.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 이진 삽입 정렬
internal object BinInsertionSort_06_08 {
    fun binInsertionSort(a: IntArray, n: Int) {
        for (i in 1 until n) {
            val key = a[i]
            var pl = 0 // 검색범위 맨 앞의 인덱스
            var pr = i - 1 // 검색범위 맨 뒤의 인덱스
            var pc: Int // 〃 중앙의 인덱스
            var pd: Int // 삽입하는 위치의 인덱스
            do {
                pc = (pl + pr) / 2
                if (a[pc] == key) // 검색성공
                    break else if (a[pc] < key) pl = pc + 1 else pr = pc - 1
            } while (pl <= pr)
            pd = if (pl <= pr) pc + 1 else pr + 1
            for (j in i downTo pd + 1) a[j] = a[j - 1]
            a[pd] = key
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        println("이진 삽입 정렬")
        print("요솟수：")
        val nx = stdIn.nextInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i]：")
            x[i] = stdIn.nextInt()
        }
        binInsertionSort(x, nx) // 배열 x를 이진삽입정렬
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx) println("x[" + i + "]＝" + x[i])
    }
}