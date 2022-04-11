package chap03.answer

import kotlin.jvm.JvmStatic
import java.util.*

// 신체검사 데이터 배열에서 검색 (시력)
internal object PhysExamSearchV_03_07 {
    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        val x = arrayOf( // 배열의 요소는 시력순이지 않으면 안됩니다.
            PhyscData("이나령", 162, 0.3), PhyscData("유지훈", 168, 0.4), PhyscData("전서현", 173, 0.7),
            PhyscData("김한결", 169, 0.8), PhyscData("이호연", 174, 1.2), PhyscData("홍준기", 171, 1.5),
            PhyscData("이수민", 175, 2.0)
        )
        print("찾는 시력은：")
        val vision = stdIn.nextDouble() // 키 값을 입력 받음
        val idx = Arrays.binarySearch(
            x,  // 배열 x에서
            PhyscData("", 0, vision),  // 키가 vision인 요소를
            PhyscData.VISION_ORDER // VISION_ORDER를 사용하여 검색
        )
        if (idx < 0) println("그 값의 요소가 없습니다.") else {
            println("그 값은 x[$idx]에 있습니다.")
            println("데이터：" + x[idx])
        }
    }

    // 신체검사 데이터
    internal class PhyscData     // 생성자
        (// 이름
        private val name: String, // 키
        private val height: Int, // 시력
        private val vision: Double
    ) {
        // 문자열을 반환합니다.
        override fun toString(): String {
            return "$name $height $vision"
        }

        private class VisionOrderComparator : Comparator<PhyscData> {
            override fun compare(d1: PhyscData, d2: PhyscData): Int {
                return if (d1.vision > d2.vision) 1 else if (d1.vision < d2.vision) -1 else 0
            }
        }

        companion object {
            // 시력 내림차순용 comparator
            val VISION_ORDER: Comparator<PhyscData> = VisionOrderComparator()
        }
    }
}