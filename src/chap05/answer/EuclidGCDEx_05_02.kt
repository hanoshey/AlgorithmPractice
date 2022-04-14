package chap05.answer

import kotlin.jvm.JvmStatic

// 유클리드의 호제법에 의해 최대 공약수를 비재귀적으로 구합니다.
internal object EuclidGCDEx_05_02 {
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

    @JvmStatic
    fun main(args: Array<String>) {
        println("두 정수의 최대 공약수를 구합니다.")
        print("정수를 입력하세요.：")
        val x = readLine()!!.toInt()
        print("정수를 입력하세요.：")
        val y = readLine()!!.toInt()
        println("최대 공약수는 ${gcd(x, y)}입니다.")
    }
}