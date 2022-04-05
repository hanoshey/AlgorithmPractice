package chap01.Answer

import kotlin.jvm.JvmStatic
import chap01.Answer.Max4_01_01
import chap01.Answer.Med3_01_04
import chap01.Answer.Min3_01_02
import chap01.Answer.Min4_01_03
import chap01.Answer.NumPira_01_17
import chap01.Answer.StarPira_01_16
import chap01.Answer.SumOf_01_09
import chap01.Answer.Triangle_01_15
import java.util.*

// 4개의 값의 최솟값을 구하여 출력
internal object Min4_01_03 {
    // a, b, c, d의 최솟값을 구하여 반환
    fun min4(a: Int, b: Int, c: Int, d: Int): Int {
        var min = a // 최솟값
        if (b < min) min = b
        if (c < min) min = c
        if (d < min) min = d
        return min
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        val a: Int
        val b: Int
        val c: Int
        val d: Int
        println("네 정수의 최솟값을 구합니다.")
        print("a의 값：")
        a = stdIn.nextInt()
        print("b의 값：")
        b = stdIn.nextInt()
        print("c의 값：")
        c = stdIn.nextInt()
        print("d의 값：")
        d = stdIn.nextInt()
        val min = min4(a, b, c, d) // a, b, c, d의 최솟값
        println("최솟값은 " + min + "입니다.")
    }
}