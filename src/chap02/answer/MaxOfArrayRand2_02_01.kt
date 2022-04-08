package chap02.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 배열의 요소의 최댓값을 출력  (요솟수와 값을 난수로 생성)
internal object MaxOfArrayRand2_02_01 {
    // 배열 a의 최댓값을 구하여 반환
    fun maxOf(a: IntArray): Int {
        var max = a[0]
        for (i in 1 until a.size) if (a[i] > max) max = a[i]
        return max
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val rand = Random()
        println("키의 최댓값을 구합니다.")
        val num = 1 + rand.nextInt(20) // 사람 수를 1~20의 난수로 생성하는
        val height = IntArray(num) // 요솟수 num인 배열을 생성
        println("사람수는 ${num}명입니다.")
        println("키는 아래처럼 됩니다.")
        for (i in 0 until num) {
            height[i] = 100 + rand.nextInt(90) // 요솟값을 난수로 결정
            println("height[" + i + "]：" + height[i])
        }
        println("최댓값은 ${maxOf(height)}입니다.")
    }
}