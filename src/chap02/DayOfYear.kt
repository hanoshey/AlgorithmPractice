package chap02

import kotlin.jvm.JvmStatic

internal object DayOfYear {
    private var mdays = arrayOf(
        intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31),
        intArrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    )

    private fun isLeap(year: Int): Int {
        return if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) 1 else 0
    }

    private fun dayOfYear(y: Int, m: Int, d: Int): Int {
        var days = d
        for (i in 1 until m) days += mdays[isLeap(y)][i - 1]
        return days
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var retry: Int
        println("그 해 경과 일수를 구합니다.")
        do {
            print("년: ")
            val year = readLine()!!.toInt()
            print("월: ")
            val month = readLine()!!.toInt()
            print("일: ")
            val day = readLine()!!.toInt()
            print("그 해 %d일째입니다.\n".format(dayOfYear(year, month, day)))
            print("한 번 더 할까요? (1.예/0.아니오) : ")
            retry = readLine()!!.toInt()
        } while (retry == 1)
    }
}