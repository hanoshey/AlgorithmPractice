package chap05

import kotlin.jvm.JvmStatic

internal object QueenB {
    var pos = IntArray(8)
    fun print() {
        for (i in 0..7) print("%2d".format(pos[i]))
        println()
    }

    //i열에 퀸을 놓습니다.
    fun set(i: Int) {
        for (j in 0..7) {
            pos[i] = j //퀸을 j행에 배치합니다
            if (i == 7) //모든 열에 배치합니다.
                print() else set(i + 1) //다음 열에 퀸을 배치합니다.
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        set(0) //0열에 퀸을 배치합니다.
    }
}