package chap03.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 이진검색 (검색과정을 자세히 출력함)
internal object BinSearchEx_03_04 {
    // 배열 a의 앞쪽 n개 요소에서 key와 같은 요소를 선형 검색 (보초법)
    fun binSearchEx(a: IntArray, n: Int, key: Int): Int {
        print("   |")
        for (k in 0 until n) print("%4d".format(k))
        println()
        print("---+")
        for (k in 0 until 4 * n + 2) print("-")
        println()
        var pl = 0 // 검색범위 맨 앞의 index
        var pr = n - 1 // 검색범위 맨 뒤의 index
        do {
            val pc = (pl + pr) / 2 // 중앙요소의 index
            print("   |")
            if (pl != pc) print(
                "%%%ds<-%%%ds+".format(pl * 4 + 1, (pc - pl) * 4).format("", "")
            ) else print(
                "%%%ds<-+".format(pc * 4 + 1).format("")
            )
            if (pc != pr) print("%%%ds->\n".format((pr - pc) * 4 - 2).format("")) else println("->")
            print("%3d|".format(pc))
            for (k in 0 until n) print("%4d".format(a[k]))
            println("\n   |")
            if (a[pc] == key) return pc // 검색성공
            else if (a[pc] < key) pl = pc + 1 // 검색범위를 뒤쪽 절반으로 좁힘
            else pr = pc - 1 // 검색범위를 앞쪽 절반으로 좁힘
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
        val idx = binSearchEx(x, num, ky) // 배열 x에서 값이 ky인 요소를 검색
        if (idx == -1) println("그 값의 요소가 없습니다.") else println("${ky}은 x[$idx]에 있습니다.")
    }
}