package chap03.answer

import kotlin.jvm.JvmStatic
import java.util.*

// Arrays.binarySearch에 의한 이진검색(실패할 때 삽입 포인트를 나타냄)
internal object BinarySearchTesterEx_03_06 {
    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        print("요솟수：")
        val num = stdIn.nextInt()
        val x = IntArray(num) // 요솟수 num인 배열
        println("오름차순으로 입력하세요.")
        print("x[0]：") // 맨 앞 요소를 입력 받음
        x[0] = stdIn.nextInt()
        for (i in 1 until num) {
            do {
                print("x[$i]：")
                x[i] = stdIn.nextInt()
            } while (x[i] < x[i - 1]) // 하나 앞의 요소보다 작으면 다시 입력
        }
        print("찾는 값：") // 키 값을 입력 받음
        val ky = stdIn.nextInt()
        val idx = Arrays.binarySearch(x, ky) // 배열 x에서 값이 ky인 요소를 검색
        if (idx < 0) {
            val insPoint = -idx - 1
            println("그 값의 요소가 없습니다.")
            System.out.printf("삽입 포인트는 %d입니다.\n", insPoint)
            System.out.printf("x[%d]의 바로 앞에 %d를 삽입하면 배열의 정렬 상태가 유지됩니다.", insPoint, ky)
        } else println("그 값은 x[$idx]에 있습니다.")
    }
}