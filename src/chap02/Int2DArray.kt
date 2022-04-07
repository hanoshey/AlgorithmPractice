package chap02

import kotlin.jvm.JvmStatic

internal object Int2DArray {
    @JvmStatic
    fun main(args: Array<String>) {
        val x = Array(2) { IntArray(4) }
        x[0][1] = 37
        x[0][3] = 54
        x[1][2] = 65
        for (i in 0..1) for (j in 0..3) println("x[$i][$j]=${x[i][j]}")
    }
}