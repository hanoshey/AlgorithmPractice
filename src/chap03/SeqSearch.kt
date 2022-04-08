package chap03

import kotlin.jvm.JvmStatic

internal object SeqSearch {
    private fun seqSearch(a: IntArray, n: Int, key: Int): Int {
        var i = 0
        while (true) {
            if (i == n) return -1 //검색 실패 -1반환
            if (a[i] == key) return i //검색 성공(인덱스 반환)
            i++
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("요솟수 : ")
        val num = readLine()!!.toInt()
        val x = IntArray(num)
        for (i in 0 until num) {
            print("x[$i] : ")
            x[i] = readLine()!!.toInt()
        }
        print("검색할 값 : ")
        val ky = readLine()!!.toInt()
        val idx = seqSearch(x, num, ky) //배열 x에서 키 값이 ky인 요소 검색
        if (idx == -1) println("그 값의 요소가 없습니다.") else println("${ky}은(는) x[$idx]에 있습니다.")
    }
}