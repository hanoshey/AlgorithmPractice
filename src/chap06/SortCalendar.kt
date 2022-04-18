package chap06

import java.util.*
import java.util.Calendar.*

internal object SortCalendar {
    @JvmStatic
    fun main(args: Array<String>) {
        val x: Array<GregorianCalendar> = arrayOf(
            GregorianCalendar(2017, NOVEMBER, 1),
            GregorianCalendar(1963, OCTOBER, 18),
            GregorianCalendar(1985, APRIL, 5)
        )
        Arrays.sort(x)
        for (i in 0 until x.size)
            print(
                "%04d년 %02d월 %02d일\n".format(
                    x[i].get(YEAR), x[i].get(MONTH) + 1, x[i].get(DATE)
                )
            )
    }
}