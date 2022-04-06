package chap01.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 1, 2, …, n의 합을 구합니다  (식1 + 2 + … + n = 999라고 출력함)
internal object SumForEx_01_07 {
    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        println("1부터 n까지의 합을 구합니다.")
        print("n의 값：")
        val n = stdIn.nextInt()
        var sum = 0 // 합
        for (i in 1..n) {
            if (i < n) print("$i + ") else print(i)
            sum += i // sum에 i를 더함
        }
        println(" = $sum")
    }
}