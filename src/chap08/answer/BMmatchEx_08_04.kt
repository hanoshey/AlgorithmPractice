package chap08.answer

import kotlin.jvm.JvmStatic

// Boyer-Moore법에 의한 문자열 검색 (조사과정을 자세히 나타냄)
internal object BMmatchEx_08_04 {
    fun bmMatch(txt: String, pat: String): Int {
        var pp: Int // pat를 따라가는 커서
        val txt_len = txt.length // txt의 문자수
        val pat_len = pat.length // pat의 문자수
        val skip = IntArray(Character.MAX_VALUE.code + 1) // skip 테이블
        var count = 0 // 비교횟수
        var k = -1

        // skip 테이블 만들기
        var pt = 0 // txt를 따라가는 커서
        while (pt <= Character.MAX_VALUE.code) {
            skip[pt] = pat_len
            pt++
        }
        pt = 0
        while (pt < pat_len - 1) {
            skip[pat[pt].code] = pat_len - pt - 1
            pt++
        }
        // pt == pat_len - 1임.
        // 검색
        while (pt < txt_len) {
            pp = pat_len - 1 // pat의 마지막 문자에 주목
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
            while (txt[pt] == pat[pp]) {
                if (pp == 0) return pt // 검색성공
                pp--
                pt--
                if (k == pt - pp) print("    ") else {
                    print("%2d  ".format(pt - pp))
                    k = pt - pp
                }
                for (i in 0 until txt.length) print("${txt[i]} ")
                println()
                for (i in 0 until pt * 2 + 4) print(" ")
                print(if (txt[pt] == pat[pp]) '+' else '|')
                println()
                for (i in 0 until (pt - pp) * 2 + 4) print(" ")
                for (i in 0 until pat.length) print("${pat[i]} ")
                println()
                println()
                count++
            }
            pt += skip[txt[pt].code]
        }
        return -1 // 검색실패
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("텍스트：")
        val s1 = readLine()!! // 텍스트용 문자열
        print("패턴：")
        val s2 = readLine()!! // 패턴용 문자열
        val idx = bmMatch(s1, s2) // 문자열 s1에서 문자열 s2를 BM법으로 검색
        if (idx == -1) println("텍스트에 패턴이 없습니다.") else {
            var len = 0
            for (i in 0 until idx) len += s1.substring(i, i + 1).toByteArray().size
            len += s2.length
            println("${(idx + 1)}번째 문자와 일치합니다.")
            println("텍스트：$s1")
            print("패턴：%%%ds\n".format(len).format(s2))
        }
    }
}