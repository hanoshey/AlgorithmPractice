package chap03

import java.util.*
import kotlin.jvm.JvmStatic

internal object BinarySearchTester {
    @JvmStatic
    fun main(args: Array<String>) {
        print("요솟수 : ")
        val num = readLine()!!.toInt()
        val x = IntArray(num)
        println("오름차순으로 입력하세요.")
        print("x[0] : ") //배열의 첫 요소를 입력합니다.
        x[0] = readLine()!!.toInt()
        for (i in 1 until num) {
            do {
                print("x[$i] : ")
                x[i] = readLine()!!.toInt()
            } while (x[i] < x[i - 1]) //앞의 요소보다 작으면 다시 입력
        }
        print("검색할 값 : ")
        val ky = readLine()!!.toInt()
        val idx = Arrays.binarySearch(x, ky) //배열 x에서 키 값이 ky인 요소 검색
        if (idx < 0) println("그 값의 요소가 없습니다.") else println(ky.toString() + "은(는) x[" + idx + "]에 있습니다.")
    }
}