package chap03.question

import chap03.question.Q7.PhyscData.Companion.VISION_ORDER
import kotlin.jvm.JvmStatic
import java.util.*

// 신체검사 데이터 배열에서 이진 검색
internal object Q7 {
    @JvmStatic
    fun main(args: Array<String>) {
        val x = arrayOf(
            // 키의 오름차순으로 정렬
            PhyscData("이나령", 162, 0.3),
            PhyscData("유지훈", 168, 0.4),
            PhyscData("전서현", 173, 0.7),
            PhyscData("김한결", 169, 0.8),
            PhyscData("이호연", 174, 1.2),
            PhyscData("홍준기", 171, 1.5),
            PhyscData("이수민", 175, 2.0),
        )
        print("시력이 몇인 사람을 찾고 있나요?: ")
        val vision = readLine()!!.toDouble() // 킷값을 읽어 들임
        val idx = Arrays.binarySearch(
            x,  // 배열 x에서
            PhyscData("", 0, vision),
            VISION_ORDER
        )
        if (idx < 0) println("그 값의 요소가 없습니다.") else {
            println("그 값은 x[$idx]에 있습니다.")
            println("찾은 데이터: " + x[idx])
        }
    }

    //--- 신체검사 데이터 ---//
    internal class PhyscData
        (
        private val name: String,
        private val height: Int,
        private val vision: Double
    ) {
        override fun toString(): String {
            return "$name $height $vision"
        }

        private class VisionOrderComparator : Comparator<PhyscData> {
            override fun compare(d1: PhyscData, d2: PhyscData): Int {
                return if (d1.vision > d2.vision) 1 else if (d1.vision < d2.vision) -1 else 0
            }
        }

        companion object {
            val VISION_ORDER: Comparator<PhyscData> = VisionOrderComparator()
        }
    }
}