package chap02.question

import java.util.*

object Q1 {
    private fun maxOf(a: IntArray): Int {
        var max = a[0]
        for (i in 1 until a.size)
            if (a[i] > max)
                max = a[i]
        return max
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val rand = Random()
        println("키의 최댓값을 구합니다.")
        val num = rand.nextInt(100) + 1
        val height = IntArray(num)
        println("키 값은 아래와 같습니다.")
        for (i in 0 until num) {
            height[i] = 100 + rand.nextInt(90)//요소의 값을 난수로 결정
            println("height[$i] : ${height[i]}")
        }
        println("최댓값은 ${maxOf(height)}입니다.")
    }
}