package chap02.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 배열 b의 모든 요소를 배열 a에 복사함
internal object Copy_02_04 {
    // 배열 b의 모든 요소를 배열 a에 복사
    fun copy(a: IntArray, b: IntArray) {
        val num = if (a.size <= b.size) a.size else b.size
        for (i in 0 until num) a[i] = b[i]
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        print("a의 요솟수는 ：")
        val numa = stdIn.nextInt() // 요솟수
        val a = IntArray(numa) // 요솟수 numa인 배열
        for (i in 0 until numa) {
            print("a[$i] : ")
            a[i] = stdIn.nextInt()
        }
        print("b의 요솟수는 ：")
        val numb = stdIn.nextInt() // 요솟수
        val b = IntArray(numb) // 요솟수 numb인 배열
        for (i in 0 until numb) {
            print("b[$i] : ")
            b[i] = stdIn.nextInt()
        }
        copy(a, b) // 배열 b의 모든 요소를 배열 a에 역순으로 복사
        println("배열 b의 모든 요소를 배열 a에 복사했습니다.")
        for (i in 0 until numa) println("a[" + i + "] = " + a[i])
    }
}