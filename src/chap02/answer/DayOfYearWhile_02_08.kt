package chap02.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 연내의 경과 일 수를 구합니다(while문을 사용).
internal object DayOfYearWhile_02_08 {
    // 각 달의 일 수
    var mdays = arrayOf(
        intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31),
        intArrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    )

    // 서기 year년은 윤년인가? (윤년：1／평년：0)
    fun isLeap(year: Int): Int {
        return if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) 1 else 0
    }

    // 서기 y년 m월 d일의 연내의 경과일수를 구합니다.
    fun dayOfYear(y: Int, m: Int, d: Int): Int {
        var m = m
        var d = d
        while (--m != 0) d += mdays[isLeap(y)][m - 1]
        return d
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        var retry: Int // 한 번더 ?
        println("연내의 경과 일 수를 구합니다.")
        do {
            print("년：")
            val year = stdIn.nextInt() // 년
            print("월：")
            val month = stdIn.nextInt() // 월
            print("일：")
            val day = stdIn.nextInt() // 일
            System.out.printf("연내 %d일째입니다.\n", dayOfYear(year, month, day))
            print("한번 더 할까요? (1.예/0.아니오)：")
            retry = stdIn.nextInt()
        } while (retry == 1)
    }
}