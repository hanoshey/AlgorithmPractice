package chap03.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 이진검색 (같은 맨 앞 요소를 찾습니다)
internal object BinSearchX_03_05 {
    // 배열 a의 앞쪽 n개 요소에서 key와 같은 요소를 이진검색
    fun binSearchX(a: IntArray, n: Int, key: Int): Int {
        var pl = 0 // 검색범위 맨 앞의 index
        var pr = n - 1 // 검색범위 맨 뒤의 index
        do {
            var pc = (pl + pr) / 2 // 중앙요소의 index
            if (a[pc] == key) {
                while (pc > pl) {
                    // key와 같은 맨 앞의 요소를 찾습니다
                    if (a[pc - 1] < key) break
                    pc--
                }
                return pc // 검색성공
            } else if (a[pc] < key) pl = pc + 1 // 검색범위를 앞쪽 절반으로 좁힘
            else pr = pc - 1 // 검색범위를 뒤쪽 절반으로 좁힘
        } while (pl <= pr)
        return -1 // 검색실패
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        print("요솟수：")
        val num = stdIn.nextInt()
        val x = IntArray(num) // 요솟수 num인 배열
        println("오름차순으로 입력하세요.")
        print("x[0]：") // 맨 앞 요소를 읽어 들임
        x[0] = stdIn.nextInt()
        for (i in 1 until num) {
            do {
                print("x[$i]：")
                x[i] = stdIn.nextInt()
            } while (x[i] < x[i - 1]) // 하나 앞의 요소보다 작으면 다시 입력
        }
        print("찾는 값：") // 키 값을 입력 받음
        val ky = stdIn.nextInt()
        val idx = binSearchX(x, num, ky) // 배열 x에서 값이 ky인 요소를 검색
        if (idx == -1) println("그 값의 요소가 없습니다.") else println(ky.toString() + "은 x[" + idx + "]에 있습니다.")
    }
}