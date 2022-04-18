package chap06

import chap06.PhyscExamSort.PhyscData.Companion.HEIGHT_ORDER
import java.util.Arrays

internal object PhyscExamSort {
    internal class PhyscData(val name: String, val height: Int, val vision: Double) {
        override fun toString(): String {
            return "$name $height $vision"
        }

        companion object {
            val HEIGHT_ORDER: Comparator<PhyscData> = HeightOrderComparator()
        }

        private class HeightOrderComparator : Comparator<PhyscData> {
            override fun compare(o1: PhyscData, o2: PhyscData): Int {
                return if (o1.height > o2.height) 1 else if (o1.height < o2.height) -1 else 0
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val x = arrayOf(
            PhyscData("이나령", 162, 0.3),
            PhyscData("전서현", 173, 0.7),
            PhyscData("이수민", 175, 2.0),
            PhyscData("홍준기", 171, 1.5),
            PhyscData("유지훈", 168, 0.4),
            PhyscData("이호연", 174, 1.2),
            PhyscData("김한결", 169, 0.8)
        )
        Arrays.sort(x, HEIGHT_ORDER)
        println("■ 신체검사 리스트 ■")
        println(" 이름         키          시력")
        println("---------------------------")
        for (i in 0 until x.size)
            print("%-8s%3d%5.1f\n".format(x[i].name, x[i].height, x[i].vision))
    }
}