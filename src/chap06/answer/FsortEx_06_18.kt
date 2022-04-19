package chap06.answer

import kotlin.jvm.JvmStatic
import java.util.*

internal object FsortEx_06_18 {
    // 도수정렬(배열 요솟값은 0 이상 max 이하)
    fun fSort(a: IntArray, n: Int, max: Int) {
        val f = IntArray(max + 1) // 누적도수
        val b = IntArray(n) // 작업용 목적배열
        println("1단계：도수분포표 만들기") // 1단계
        for (i in 0 until n) {
            for (k in 0..max) System.out.printf("%3d", f[k])
            println()
            f[a[i]]++
        }
        for (k in 0..max) System.out.printf("%3d", f[k])
        println()
        println("2단계：누적도수분포표 만들기") // 2단계
        for (i in 1..max) {
            for (k in 0..max) System.out.printf("%3d", f[k])
            println()
            f[i] += f[i - 1]
        }
        for (k in 0..max) System.out.printf("%3d", f[k])
        println()
        println("3단계：정렬") // 3단계
        for (i in n - 1 downTo 0) {
            for (k in 0 until n) System.out.printf("%3d", b[k])
            println()
            b[--f[a[i]]] = a[i]
        }
        for (k in 0 until n) System.out.printf("%3d", b[k])
        println()
        for (i in 0 until n) a[i] = b[i] // 4단계
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("도수정렬 ")
        print("요솟수：")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            do {
                print("x[$i]：")
                x[i] = readLine()!!.toInt()
            } while (x[i] < 0)
        }
        var max = x[0]
        for (i in 1 until nx) if (x[i] > max) max = x[i]
        fSort(x, nx, max) // 배열 x를 도수정렬
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx) println("x[$i]＝${x[i]}")
    }
}