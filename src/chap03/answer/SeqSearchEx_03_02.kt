package chap03.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 선형 검색 (검색과정을 자세히 나타냄)
internal object SeqSearchEx_03_02 {
    // 배열 a의 앞쪽 n개 요소에서 key와 같은 요소를 선형 검색 (보초법)
    fun seqSearchEx(a: IntArray, n: Int, key: Int): Int {
        print("   |")
        for (k in 0 until n) print("%4d".format(k))
        println()
        print("---+")
        for (k in 0 until 4 * n + 2) print("-")
        println()
        for (i in 0 until n) {
            print("   |")
            print("%%%ds*\n".format(i * 4 + 3).format(""))
            print("%3d|".format(i))
            for (k in 0 until n) print("%4d".format(a[k]))
            println("\n   |")
            if (a[i] == key) return i // 검색성공
        }
        return -1 // 검색실패
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        print("요솟수：")
        val num = stdIn.nextInt()
        val x = IntArray(num) // 요솟수 num인 배열
        for (i in 0 until num) {
            print("x[$i]：")
            x[i] = stdIn.nextInt()
        }
        print("찾는 값：") // 키 값을 입력 받음
        val ky = stdIn.nextInt()
        val idx = seqSearchEx(x, num, ky) // 배열 x에서 값이 ky인 요소를 검색
        if (idx == -1) println("그 값의 요소가 없습니다.") else println("${ky}은 x[$idx]에 있습니다.")
    }
}