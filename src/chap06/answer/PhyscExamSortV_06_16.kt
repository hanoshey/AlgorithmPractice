package chap06.answer

import kotlin.jvm.JvmStatic
import java.util.Arrays
import java.util.Comparator

internal object PhyscExamSortV_06_16 {
    @JvmStatic
    fun main(args: Array<String>) {
        val x = arrayOf(
            PhyscData("이나령", 162, 0.3), PhyscData("전서현", 173, 0.7),
            PhyscData("이수민", 175, 2.0), PhyscData("홍준기", 171, 1.5), PhyscData("유지훈", 168, 0.4),
            PhyscData("이호연", 174, 1.2), PhyscData("김한결", 169, 0.8)
        )
        Arrays.sort(
            x,  // 배열 x를
            PhyscData.VISION_RORDER // HEIGHT_ORDER를 사용하여 sort
        )
        println("■ 신체검사 리스트 ■")
        println(" 이름       키        시력")
        println("---------------")
        for (i in x.indices) System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision)
    }

    // 신체검사 데이터
    internal class PhyscData     // 생성자
        (// 이름
        var name: String, // 키
        var height: Int, // 시력
        var vision: Double
    ) {
        // 문자열로
        override fun toString(): String {
            return "$name $height $vision"
        }

        private class VisionROrderComparator : Comparator<PhyscData> {
            override fun compare(d1: PhyscData, d2: PhyscData): Int {
                return if (d1.vision < d2.vision) 1 else if (d1.vision > d2.vision) -1 else 0
            }
        }

        companion object {
            // 시력 내림차순용 comparator
            val VISION_RORDER: Comparator<PhyscData> = VisionROrderComparator()
        }
    }
}