package chap02.answer

import kotlin.jvm.JvmStatic

// 신체검사 데이터용 클래스의 배열에서 평균키와 시력의 분포를 구합니다.(그래프로 나타냄)
internal object PhysicalExaminationEx_02_10 {
    const val VMAX = 21 // 시력의 분포 (0.0부터 0.1 단위로 21개)

    // 키의 평균값을 구합니다.
    private fun aveHeight(dat: Array<PhyscData>): Double {
        var sum = 0.0
        for (i in dat.indices) sum += dat[i].height.toDouble()
        return sum / dat.size
    }

    // 시력의 분포를 구합니다.
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
            PhyscData("이나령", 162, 0.3), PhyscData("전서현", 173, 0.7),
            PhyscData("이수민", 175, 2.0), PhyscData("홍준기", 171, 1.5),
            PhyscData("유지훈", 168, 1.2), PhyscData("이호연", 174, 1.2),
            PhyscData("김한결", 169, 0.8)
        )
        val vdist = IntArray(VMAX) // 시력의 분포
        println("■ 신체검사 리스트 ■")
        println(" 이름      키      시력")
        println("--------------")
        for (i in x.indices) print("%-8s%3d%5.1f\n".format(x[i].name, x[i].height, x[i].vision))
        print("\n평균키：%5.1fcm\n".format(aveHeight(x)))
        distVision(x, vdist) // 시력의 분포를 구합니다.
        println("\n시력의 분포")
        for (i in 0 until VMAX) {
            print("%3.1f~：".format(i / 10.0))
            for (j in 0 until vdist[i]) print('*')
            println()
        }
    }

    internal class PhyscData     // 생성자
        (
        var name: String, // 키
        var height: Int, // 시력
        var vision: Double
    )
}