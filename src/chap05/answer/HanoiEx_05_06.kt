package chap05.answer

import kotlin.jvm.JvmStatic

// 하노이의 탑(기둥 이름을 문자열로 나타냄)
internal object HanoiEx_05_06 {
    var name = arrayOf("A기둥", "B기둥", "C기둥")

    // 원반을 x기둥에서 y기둥으로 옮김
    fun move(no: Int, x: Int, y: Int) {
        if (no > 1) move(no - 1, x, 6 - x - y)
        println("원반[$no]를 ${name[x - 1]}에서 ${name[y - 1]}으로 옮김")
        if (no > 1) move(no - 1, 6 - x - y, y)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("하노이의 탑")
        print("원반의 갯수：")
        val n = readLine()!!.toInt()
        move(n, 1, 3) // 1기둥에 쌓인 n개를 3기둥에 옮김
    }
}