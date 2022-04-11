package chap03.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 어떤 값을 갖는 배열 안의 모든 요소를 다른 배열에 복사함
internal object SearchIndex_03_03 {
    // 배열 a의 앞쪽 n개 요소에서 key와 같은 모든 요소의 index를 배열idx의 머리부터 차례로 저장하여 같은 요솟수를 반환
    fun searchIdx(a: IntArray, n: Int, key: Int, idx: IntArray): Int {
        var count = 0 // key와 같은 요솟수
        for (i in 0 until n) if (a[i] == key) idx[count++] = i
        return count
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        print("요솟수：")
        val num = stdIn.nextInt()
        val x = IntArray(num) // 요솟수 num인 배열
        val y = IntArray(num) // 요솟수 num인 배열
        for (i in 0 until num) {
            print("x[$i]：")
            x[i] = stdIn.nextInt()
        }
        print("찾는 값：") // 키 값을 입력 받음
        val ky = stdIn.nextInt()
        val count = searchIdx(x, num, ky, y)
        if (count == 0) println("그 값의 요소가 없습니다.") else for (i in 0 until count) println("그 값은 x[${y[i]}]에 있습니다.")
    }
}