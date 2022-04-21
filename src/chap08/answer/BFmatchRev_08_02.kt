package chap08.answer

import kotlin.jvm.JvmStatic

// 브루트-포스법에 의한 문자열 검색(같은 문자열을 꼬리쪽부터 검색)
internal object BFmatchRev_08_02 {
    fun bfMatchLast(txt: String, pat: String): Int {
        var pt = txt.length - 1 // txt를 따라가는 커서
        var pp = pat.length - 1 // pat를 따라가는 커서
        while (pt >= 0 && pp >= 0) {
            if (txt[pt] == pat[pp]) {
                pt--
                pp--
            } else {
                pt = pt + (pat.length - pp) - 2
                pp = pat.length - 1
            }
        }
        return if (pp < 0) pt + 1 else -1
        // 검색실패
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("텍스트：")
        val s1 = readLine()!! // 텍스트용 문자열
        print("패턴：")
        val s2 = readLine()!!
        val idx = bfMatchLast(s1, s2) // 문자열 s1에서 문자열 s2를 브루트-포스법으로 검색
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