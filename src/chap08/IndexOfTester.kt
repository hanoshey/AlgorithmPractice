package chap08
internal object IndexOfTester {
    @JvmStatic
    fun main(args: Array<String>) {
        print("텍스트: ")
        val s1 = readLine()!! // 텍스트용 문자열
        print("패  턴: ")
        val s2 = readLine()!! // 패턴용 문자열
        val idx1 = s1.indexOf(s2) // 문자열 s1에서 s2를 검색(앞쪽부터)
        val idx2 = s1.lastIndexOf(s2) // 문자열 s1에서 s2를 검색(뒤쪽부터)
        if (idx1 == -1) println("텍스트 안에 패턴이 없습니다.") else {
            // 찾아낸 문자열 바로 앞까지의 문자 개수를 구함
            var len1 = 0
            for (i in 0 until idx1) len1 += s1.substring(i, i + 1).toByteArray().size
            len1 += s2.length
            var len2 = 0
            for (i in 0 until idx2) len2 += s1.substring(i, i + 1).toByteArray().size
            len2 += s2.length
            println("텍스트: $s1")
            print("패  턴: %%%ds\n".format(len1).format(s2))
            println("텍스트: $s1")
            print("패  턴: %%%ds\n".format(len2).format(s2))
        }
    }
}