package chap08

internal object BMmatch {
    //--- 보이어-무어법으로 문자열 검색 ---//
    fun bmMatch(txt: String, pat: String): Int {
        var pp: Int // pat를 따라가는 커서
        val txtLen = txt.length // txt의 문자 개수
        val patLen = pat.length // pat의 문자 개수
        val skip = IntArray(Character.MAX_VALUE.code + 1) // 건너뛰기 표(skip 테이블)

        // skip 테이블 작성
        var pt = 0 // txt를 따라가는 커서
        while (pt <= Character.MAX_VALUE.code) {
            skip[pt] = patLen
            pt++
        }
        pt = 0
        while (pt < patLen - 1) {
            skip[pat[pt].code] = patLen - pt - 1 // pt == patLen - 1
            pt++
        }
        // 검색
        while (pt < txtLen) {
            pp = patLen - 1 // pat의 마지막 문자에 주목
            while (txt[pt] == pat[pp]) {
                if (pp == 0) return pt // 검색 성공
                pp--
                pt--
            }
            pt += if (skip[txt[pt].code] > patLen - pp) skip[txt[pt].code] else patLen - pp
        }
        return -1 // 검색 실패
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("텍스트: ")
        val s1 = readLine()!! // 텍스트용 문자열
        print("패  턴: ")
        val s2 = readLine()!! // 패턴용 문자열
        val idx = bmMatch(s1, s2) // 문자열 s1에서 문자열 s2를 BM법으로 검색
        if (idx == -1) println("텍스트 안에 패턴이 없습니다.") else {
            // 일치하는 문자 바로 앞까지 반각(1바이트) 문자의 개수를 구합니다
            var len = 0
            for (i in 0 until idx) len += s1.substring(i, i + 1).toByteArray().size
            len += s2.length
            println((idx + 1).toString() + "번째 문자부터 일치합니다.")
            println("텍스트: $s1")
            print("패  턴: %%%ds\n".format(len).format(s2))
        }
    }
}