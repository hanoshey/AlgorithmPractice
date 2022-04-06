package chap01.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 4가지의 직각삼각형 모양으로 나타냄
object Triangle_01_15 {
    // 왼쪽 아래가 직각인 이등변삼각형을 출력
    fun triangleLB(n: Int) {
        for (i in 1..n) {                // i행 (i = 1, 2, … ,n)
            for (j in 1..i)  // i개의 '*'를 나타냄
                print('*')
            println() // 개행(줄변환)
        }
    }

    // 왼쪽 위가 직각인 이등변삼각형을 출력
    fun triangleLU(n: Int) {
        for (i in 1..n) {                // i행 (i = 1, 2, … ,n)
            for (j in 1..n - i + 1)  // n-i+1개의 '*'를 나타냄
                print('*')
            println() // 개행(줄변환)
        }
    }

    // 오른쪽 위가 직각인 이등변삼각형을 출력
    fun triangleRU(n: Int) {
        for (i in 1..n) {                // i행 (i = 1, 2, … ,n)
            for (j in 1 until i)  // i-1개의 ' '를 나타냄
                print(' ')
            for (j in 1..n - i + 1)  // n-i+1개의 '*'를 나타냄
                print('*')
            println() // 개행(줄변환)
        }
    }

    // 오른쪽 아래가 직각인 이등변삼각형을 출력
    fun triangleRB(n: Int) {
        for (i in 1..n) {                // i행 (i = 1, 2, … ,ln)
            for (j in 1..n - i)  // n-i개의 ' '를 나타냄
                print(' ')
            for (j in 1..i)  // i개의 '*'를 나타냄
                print('*')
            println() // 개행(줄변환)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        var n: Int
        println("삼각형 모양으로 나타냅니다.")
        do {
            print("단수는 ：")
            n = stdIn.nextInt()
        } while (n <= 0)
        println("왼쪽 아래가 직각인 삼각형")
        triangleLB(n) // 왼쪽 아래가 직각인 이등변삼각형
        println("왼쪽 위가 직각인 삼각형")
        triangleLU(n) // 왼쪽 위가 직각인 이등변삼각형
        println("오른쪽 위가 직각인 삼각형")
        triangleRU(n) // 오른쪽 위가 직각인 이등변삼각형
        println("오른쪽 아래가 직각인 삼각형")
        triangleRB(n) // 오른쪽 아래가 직각인 이등변삼각형
    }
}