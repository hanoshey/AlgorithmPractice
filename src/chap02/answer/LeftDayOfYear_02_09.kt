package chap02.answer

import kotlin.jvm.JvmStatic

// 연내의 남은 일 수를 구합니다.
internal object LeftDayOfYear_02_09 {
    var mdays = arrayOf(
        intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31),
        intArrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    )

    // 서기 year년은 윤년인가? (윤년：1／평년：0)
    fun isLeap(year: Int): Int {
        return if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) 1 else 0
    }

    // 서기 y년 m월 d일의 연내의 남은 일 수를 구합니다.
    fun leftDayOfYear(y: Int, m: Int, d: Int): Int {
        var days = d // 일수
        for (i in 1 until m)  // 1월~(m-1)월의 일 수를 더함
            days += mdays[isLeap(y)][i - 1]
        return 365 + isLeap(y) - days
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var retry: Int // 한 번 더？
        println("연내의 남은 일 수를 구합니다.")
        do {
            print("년：")
            val year = readLine()!!.toInt() // 년
            print("월：")
            val month = readLine()!!.toInt() // 월
            print("일：")
            val day = readLine()!!.toInt() // 일
            print("연내의 남은 일 수는 %d일입니다.\n".format(leftDayOfYear(year, month, day)))
            print("한번 더 할까요? (1.예/0.아니오)：")
            retry = readLine()!!.toInt()
        } while (retry == 1)
    }
}