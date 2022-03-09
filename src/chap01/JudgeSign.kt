package chap01

import java.util.*
import kotlin.jvm.JvmStatic

object JudgeSign {
    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        print("정수를 입력하세요. : ")
        val n = stdIn.nextInt()
        if (n > 0) println("이 수는 양수입니다.") else if (n < 0) println("이 수는 음수입니다.") else println("이 수는 0입니다.")
    }
}