package chap02

import kotlin.jvm.JvmStatic

internal object PhysicalExamination {
    const val VMAX = 21 //시력 분포(0.0에서 0.1단위로 21개)
    private fun aveHeight(dat: Array<PhyscData>): Double {
        var sum = 0.0
        for (i in dat.indices) sum += dat[i].height.toDouble()
        return sum / dat.size
    }

    //시력 분포를 구함
    private fun distVision(dat: Array<PhyscData>, dist: IntArray) {
        var i = 0
        dist[i] = 0
        i = 0
        while (i < dat.size) {
            if (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0) dist[(dat[i].vision * 10).toInt()]++
            i++
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val x = arrayOf(
            PhyscData("박현규", 162, 0.3),
            PhyscData("함진아", 173, 0.7),
            PhyscData("최윤미", 175, 2.0),
            PhyscData("홍연의", 171, 1.5),
            PhyscData("이수진", 168, 0.4),
            PhyscData("김영준", 174, 1.2),
            PhyscData("박용규", 169, 0.8)
        )
        val vdist = IntArray(VMAX) //시력 분포
        println("■ 신체검사 리스트 ■")
        println("이름         키      시력")
        println("-----------------------")
        for (i in x.indices) System.out.printf(
            "%-8s%3d%5.1f\n",
            x[i].name, x[i].height, x[i].vision
        )
        System.out.printf("\n평균 키 : %5.1fcm\n", aveHeight(x))
        distVision(x, vdist)
        println("\n시력 분포")
        for (i in 0 until VMAX) System.out.printf("%3.1f~ : %2d명\n", i / 10.0, vdist[i])
    }

    private class PhyscData(var name: String, var height: Int, var vision: Double)
}