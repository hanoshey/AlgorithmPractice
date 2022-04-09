package chap03

import kotlin.jvm.JvmStatic

internal object SeqSearchSen {
    private fun seqSearchSen(a: IntArray, n: Int, key: Int): Int {
        var i = 0
        a[n] = key //보초를 추가
        while (true) {
            if (a[i] == key) break
            i++
        }
        return if (i == n) -1 else i
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("요솟수: ")
        val num = readLine()!!.toInt()
        val x = IntArray(num + 1) //요솟수+1
        for (i in 0 until num) {
            print("x[$i] : ")
            x[i] = readLine()!!.toInt()
        }
        print("검색할 값 : ") //키 값을 입력
        val ky = readLine()!!.toInt()
        val idx = seqSearchSen(x, num, ky)
        if (idx == -1) println("그 값의 요소가 없습니다.") else println("${ky}은(는) x[$idx]에 있습니다.")
    }
}