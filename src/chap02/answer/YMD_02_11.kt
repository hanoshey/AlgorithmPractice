package chap02.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 날짜 클래스 
internal class YMD_02_11(var y: Int, var m: Int, var d: Int) {
    // n일 뒤의 날짜를 반환
    fun after(n: Int): YMD_02_11 {
        val temp = YMD_02_11(y, m, d)
        if (n < 0) return before(-n)
        temp.d += n
        while (temp.d > mdays[isLeap(temp.y)][temp.m - 1]) {
            temp.d -= mdays[isLeap(temp.y)][temp.m - 1]
            if (++temp.m > 12) {
                temp.y++
                temp.m = 1
            }
        }
        return temp
    }

    // n일 앞의 날짜를 반환
    fun before(n: Int): YMD_02_11 {
        val temp = YMD_02_11(y, m, d)
        if (n < 0) return after(-n)
        temp.d -= n
        while (temp.d < 1) {
            if (--temp.m < 1) {
                temp.y--
                temp.m = 12
            }
            temp.d += mdays[isLeap(temp.y)][temp.m - 1]
        }
        return temp
    }

    companion object {
        // 각 달의 일수
        var mdays = arrayOf(
            intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31),
            intArrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        )

        // 서기 year년은 윤년인가? (윤년：1／평년：0)
        fun isLeap(year: Int): Int {
            return if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) 1 else 0
        }

        @JvmStatic
        fun main(args: Array<String>) {
            val stdIn = Scanner(System.`in`)
            print("날짜를 입력하세요.\n")
            print("년：")
            val y = stdIn.nextInt()
            print("월：")
            val m = stdIn.nextInt()
            print("일：")
            val d = stdIn.nextInt()
            val date = YMD_02_11(y, m, d)
            print("몇 일 앞/뒤의 날짜를 구할까요?：")
            val n = stdIn.nextInt()
            val d1 = date.after(n)
            System.out.printf("%d일 뒤의 날짜는 %d년 %d월 %d일입니다.\n", n, d1.y, d1.m, d1.d)
            val d2 = date.before(n)
            System.out.printf("%d일 앞의 날짜는 %d년 %d월 %d일입니다.\n", n, d2.y, d2.m, d2.d)
        }
    }
}