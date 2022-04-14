package chap05.answer

import kotlin.jvm.JvmStatic

// 배열의 모든 요소의 최대 공약수를 구합니다.
internal object GCDArray_05_03 {
    // 정수 x, y의 최대 공약수를 비재귀적으로 구하여 반환
    fun gcd(x: Int, y: Int): Int {
        var x = x
        var y = y
        while (y != 0) {
            val temp = y
            y = x % y
            x = temp
        }
        return x
    }

    // 요솟수 n인 배열 a의 모든 요소의 최대 공약수를 구합니다.
    fun gcdArray(a: IntArray, start: Int, no: Int): Int {
        return when (no) {
            1 -> a[start]
            2 -> gcd(a[start], a[start + 1])
            else -> gcd(a[start], gcdArray(a, start + 1, no - 1))
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("정수 몇 개의 최대 공약수를 구할까요?：")
        var num: Int
        do {
            num = readLine()!!.toInt()
        } while (num <= 1)
        val x = IntArray(num) // 길이 num인 배열
        for (i in 0 until num) {
            print("x[$i]：")
            x[i] = readLine()!!.toInt()
        }
        println("최대 공약수는 ${gcdArray(x, 0, num)}입니다.")
    }
}