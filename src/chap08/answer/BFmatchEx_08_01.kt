package chap08.answer

import kotlin.jvm.JvmStatic

// 브루트-포스법에 의한 문자열 검색 (조사과정을 자세히 나타냄)
internal object BFmatchEx_08_01 {
    fun bfMatch(txt: String, pat: String): Int {
        var pt = 0 // txt를 따라가는 커서
        var pp = 0 // pat를 따라가는 커서
        var count = 0 // 비교횟수
        var k = -1
        while (pt != txt.length && pp != pat.length) {
            if (k == pt - pp) print("    ") else {
                print("%2d  ".format(pt - pp))
                k = pt - pp
            }
            for (i in 0 until txt.length) print(txt[i].toString() + " ")
            println()
            for (i in 0 until pt * 2 + 4) print(" ")
            print(if (txt[pt] == pat[pp]) '+' else '|')
            println()
            for (i in 0 until (pt - pp) * 2 + 4) print(" ")
            for (i in 0 until pat.length) print(pat[i].toString() + " ")
            println()
            println()
            count++
            if (txt[pt] == pat[pp]) {
                pt++
                pp++
            } else {
                pt = pt - pp + 1
                pp = 0
            }
        }
        print("비교는 %d회였습니다.\n".format(count))
        return if (pp == pat.length) pt - pp else -1
        // 검색실패
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("텍스트：")
        val s1 = readLine()!! // 텍스트용 문자열
        print("패턴：")
        val s2 = readLine()!! // 패턴용 문자열
        val idx = bfMatch(s1, s2) // 문자열 s1에서 문자열 s2를 브루트-포스법으로 검색
        if (idx == -1) println("텍스트에 패턴이 없습니다.") else {
            var len = 0
            for (i in 0 until idx) len += s1.substring(i, i + 1).toByteArray().size
            len += s2.length
        }
    }
}