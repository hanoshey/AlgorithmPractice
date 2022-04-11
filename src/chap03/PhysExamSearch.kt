package chap03

import kotlin.jvm.JvmStatic
import chap03.PhysExamSearch.PhyscData.Companion.HEIGHT_ORDER
import java.util.*

// 신체검사 데이터 배열에서 이진 검색
internal object PhysExamSearch {
    @JvmStatic
    fun main(args: Array<String>) {
        val x = arrayOf( // 키의 오름차순으로 정렬
            PhyscData("강민하", 162, 0.3),
            PhyscData("이수연", 168, 0.4),
            PhyscData("황지안", 169, 0.8),
            PhyscData("유서범", 171, 1.5),
            PhyscData("김찬우", 173, 0.7),
            PhyscData("장경오", 174, 1.2),
            PhyscData("박준서", 175, 2.0)
        )
        print("키가 몇 cm인 사람을 찾고 있나요?: ")
        val height = readLine()!!.toInt() // 킷값을 읽어 들임
        val idx = Arrays.binarySearch(
            x,  // 배열 x에서
            PhyscData("", height, 0.0),  // 키가 height인 요소를
            HEIGHT_ORDER // HEIGHT_ORDER에 의해 검색
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
        //--- 문자열로 만들어 반환하는 메서드 --//
        override fun toString(): String {
            return "$name $height $vision"
        }

        private class HeightOrderComparator : Comparator<PhyscData> {
            override fun compare(d1: PhyscData, d2: PhyscData): Int {
                return if (d1.height > d2.height) 1 else if (d1.height < d2.height) -1 else 0
            }
        }

        companion object {
            val HEIGHT_ORDER: Comparator<PhyscData> = HeightOrderComparator()
        }
    }
}