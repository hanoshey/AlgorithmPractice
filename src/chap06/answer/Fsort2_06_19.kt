package chap06.answer

import kotlin.jvm.JvmStatic
import java.util.*

internal object Fsort2_06_19 {
    // 도수정렬(배열 요솟값은 min 이상 max이하)
    fun fSort(a: IntArray, n: Int, min: Int, max: Int) {
        val f = IntArray(max - min + 2) // 누적도수
        val b = IntArray(n) // 작업용 목적배열
        for (i in 0 until n) f[a[i] - min]++ // 1단계
        for (i in 1..max - min + 1) f[i] += f[i - 1] // 2단계
        for (i in n - 1 downTo 0) b[--f[a[i] - min]] = a[i] // 3단계
        for (i in 0 until n) a[i] = b[i] // 4단계
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        println("도수정렬 ")
        print("요솟수：")
        val nx = stdIn.nextInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            do {
                print("x[$i]：")
                x[i] = stdIn.nextInt()
            } while (x[i] < 0)
        }
        var max = x[0]
        for (i in 1 until nx) if (x[i] > max) max = x[i]
        var min = x[0]
        for (i in 1 until nx) if (x[i] < min) min = x[i]
        fSort(x, nx, min, max) // 배열 x를 도수정렬
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx) println("x[" + i + "]＝" + x[i])
    }
}