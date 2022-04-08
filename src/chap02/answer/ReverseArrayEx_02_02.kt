package chap02.answer

import kotlin.jvm.JvmStatic

// 배열 요솟값을 읽어 들여 역순으로 정렬
internal object ReverseArrayEx_02_02 {
    // 배열의 요소 a[idx1]와 a[idx2]를 교환
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    // 배열 a의 요소 값을 나타냄
    fun print(a: IntArray) {
        for (i in a.indices) print(a[i].toString() + " ")
        println()
    }

    // 배열 a의 요소를 역순으로 정렬
    fun reverse(a: IntArray) {
        print(a)
        for (i in 0 until a.size / 2) {
            println("a[$i]와 a[${(a.size - i - 1)}]를 교환합니다.")
            swap(a, i, a.size - i - 1)
            print(a)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("요솟수는 ：")
        val num = readLine()!!.toInt() // 요솟수
        val x = IntArray(num) // 요솟수 num인 배열
        for (i in 0 until num) {
            print("x[$i] : ")
            x[i] = readLine()!!.toInt()
        }
        reverse(x) // 배열 a의 요소를 역순으로 정렬
        println("역순 정렬을 마쳤습니다.")
        //		for (int i = 0; i < num; i++)
//			System.out.println("x[" + i + "] = " + x[i]);
    }
}