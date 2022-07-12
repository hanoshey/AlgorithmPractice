package chap08.answer

import kotlin.jvm.JvmStatic

// KMP법에 의한 문자열 검색(조사과정을 자세히 나타냄)
internal object KMPmatchEx_08_03 {
    fun kmpMatch(txt: String, pat: String): Int {
        var pt = 1 // txt를 따라가는 커서
        var pp = 0 // pat를 따라가는 커서
        var count = 0 // 비교횟수
        val skip = IntArray(pat.length + 1) // skip 테이블
        var k = -1

        // skip 테이블 만들기
        println("skip 테이블 만들기")
        skip[pt] = 0
        while (pt != pat.length) {
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
            if (pat[pt] == pat[pp]) skip[++pt] = ++pp else if (pp == 0) skip[++pt] = pp else pp = skip[pp]
        }

        // 검색
        println("검색")
        pp = 0
        pt = pp
        while (pt != txt.length && pp != pat.length) {
            if (k == pt - pp) print("    ") else {
                print("%2d  ".format(pt - pp))
                k = pt - pp
            }
            for (element in txt) print("$element ")
            println()
            for (i in 0 until pt * 2 + 4) print(" ")
            print(if (txt[pt] == pat[pp]) '+' else '|')
            println()
            for (i in 0 until (pt - pp) * 2 + 4) print(" ")
            for (element in pat) print("$element ")
            println()
            println()
            count++
            if (txt[pt] == pat[pp]) {
                pt++
                pp++
            } else if (pp == 0) pt++ else pp = skip[pp]
        }
        print("비교는 %d회입니다.\n".format(count))
        return if (pp == pat.length) pt - pp else -1
        // 검색실패
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("텍스트：")
        val s1 = readLine()!! // 텍스트용 문자열
        print("패턴：")
        val s2 = readLine()!! // 패턴용 문자열
        val idx = kmpMatch(s1, s2) // 문자열 s1에서 문자열 s2를 KMP법으로 검색
        if (idx == -1) println("텍스트에 패턴이 없습니다.") else {
            var len = 0
            for (i in 0 until idx) len += s1.substring(i, i + 1).toByteArray().size
            len += s2.length
            println((idx + 1).toString() + "번째 문자와 일치합니다.")
            println("텍스트：$s1")
            print("패턴：%%%ds\n".format(len).format(s2))
        }
    }
}