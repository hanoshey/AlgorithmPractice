package chap03.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 선형 검색(보초법：for문을 사용하여 구현)
internal object SeqSearchSenFor_03_01 {
    // 배열 a의 앞쪽 n개 요소에서 key와 같은 요소를 선형 검색(보초법)
    fun seqSearchSen(a: IntArray, n: Int, key: Int): Int {
        a[n] = key // 보초를 추가
        var i = 0
        while (a[i] != key) {
            i++
        }
        return if (i == n) -1 else i
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        print("요솟수：")
        val num = stdIn.nextInt()
        val x = IntArray(num + 1) // 요솟수 num + 1인 배열
        for (i in 0 until num) {
            print("x[$i]：")
            x[i] = stdIn.nextInt()
        }
        print("찾는 값：") // 키 값을 입력 받음
        val ky = stdIn.nextInt()
        val idx = seqSearchSen(x, num, ky) // 배열 x에서 값이 ky인 요소를 검색
        if (idx == -1) println("그 값의 요소가 없습니다.") else println("그 값은 x[$idx]에 있습니다.")
    }
}