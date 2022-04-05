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

// 양의 정수값의 자릿수를 구하여 나타냄
internal object DigitsNo_01_11 {
    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        println("양의 정수값의 자릿수를 구합니다.")
        var n: Int
        do {
            print("정수값：")
            n = stdIn.nextInt()
        } while (n <= 0)
        var no = 0 // 자릿수
        while (n > 0) {
            n /= 10 // n을 10으로 나눔
            no++
        }
        println("그 수는 " + no + "자리입니다.")
    }
}