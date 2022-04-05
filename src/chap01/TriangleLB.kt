package chap01

import java.util.Scanner

object TriangleLB {
    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        var n: Int
        println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.")
        do {
            print("몇 단 삼각형입니까? :")
            n = stdIn.nextInt()
        } while (n <= 0)
        for (i in 1..n) {
            for (j in 1..i)
                print("*")
            println()
        }
    }
}