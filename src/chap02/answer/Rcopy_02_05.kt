package chap02.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 배열 b의 모든 요소를 배열 a에 역순으로 copy하는 메소드를 작성하세요.
internal object Rcopy_02_05 {
    // 배열 b의 모든 요소를 배열 a에 역순으로 복사
    fun rcopy(a: IntArray, b: IntArray) {
        val num = if (a.size <= b.size) a.size else b.size
        for (i in 0 until num) a[i] = b[b.size - i - 1]
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("a의 요솟수는 ：")
        val numa = readLine()!!.toInt() // 요솟수
        val a = IntArray(numa) // 요솟수 numa인 배열
        for (i in 0 until numa) {
            print("a[$i] : ")
            a[i] = readLine()!!.toInt()
        }
        print("b의 요솟수는 ：")
        val numb = readLine()!!.toInt() // 요솟수
        val b = IntArray(numb) // 요솟수 numb인 배열
        for (i in 0 until numb) {
            print("b[$i] : ")
            b[i] = readLine()!!.toInt()
        }
        rcopy(a, b) // 배열 b의 모든 요소를 배열 a에 역순으로 copy
        println("배열 b의 모든 요소를 배열 a에 역순으로 복사했습니다.")
        for (i in 0 until numa) println("a[$i] =  ${a[i]}")
    }
}