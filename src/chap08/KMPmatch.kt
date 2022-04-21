package chap08

internal object KMPmatch {
    fun kmpMatch(txt: String, pat: String): Int {
        var pt = 1
        var pp = 0
        val skip = IntArray(pat.length + 1)//건너뛰기 표
        skip[pt] = 0
        while (pt != pat.length) {
            if (pat[pt] == pat[pp])
                skip[++pt] = ++pp
            else if (pp == 0)
                skip[++pt] = pp
            else
                pp = skip[pp]
        }
        println()
        pp = 0
        pt = pp
        while (pt != txt.length && pp != pat.length) {
            if (txt[pt] == pat[pp]) {
                pt++
                pp++
            } else if (pp == 0) {
                pt++
            } else {
                pp = skip[pp]
            }
        }
        if (pp == pat.length)
            return pt - pp
        return -1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("텍스트 : ")
        val s1 = readLine()!!
        print("패턴 : ")
        val s2 = readLine()!!
        val idx = kmpMatch(s1, s2)
        if (idx == -1)
            println("텍스트에 패턴이 없습니다.")
        else {//일치하는 문자 바로 앞까지의 길이를 구합니다.
            var len = 0
            for (i in 0 until idx)
                len += s1.substring(i, i + 1).toByteArray().size
            len += s2.length
            println("${idx + 1}번째 문자부터 일치합니다.")
            println("텍스트 : $s1")
            println("패턴 : %%%ds\n".format(len).format(s2))
        }
    }
}