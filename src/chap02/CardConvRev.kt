package chap02

import kotlin.jvm.JvmStatic

object CardConvRev {
    fun cardConvR(x: Int, r: Int, d: CharArray): Int {
        var x = x
        var digits = 0
        val dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        do {
            d[digits++] = dchar[(x % r)]
            x /= r
        } while (x != 0)
        return digits
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var no: Int //변환하는 정수
        var cd: Int //기수
        var dno: Int //변환 후의 자릿수
        var retry: Int //다시 한 번?
        val cno = CharArray(32)
        println("10진수를 기수 변환합니다.")
        do {
            do {
                print("변환하는 음이 아닌 정수")
                no = readLine()!!.toInt()
            } while (no < 0)
            do {
                print("어떤 진수로 변환할까요? (2~36) : ")
                cd = readLine()!!.toInt()
            } while (cd < 2 || cd > 36)
            dno = cardConvR(no, cd, cno)
            print(cd.toString() + "진수로는 ")
            for (i in dno - 1 downTo 0) print(cno[i])
            println("입니다.")
            print("한 번 더 할까요? (1.예/0.아니오) : ")
            retry = readLine()!!.toInt()
        } while (retry == 1)
    }
}