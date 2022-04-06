package chap01.answer

import kotlin.jvm.JvmStatic

internal object Add99TableEx_01_13 {
    @JvmStatic
    fun main(args: Array<String>) {
        print("   |")
        for (i in 1..9) System.out.printf("%3d", i)
        println("\n---+---------------------------")
        for (i in 1..9) {
            System.out.printf("%2d |", i)
            for (j in 1..9) System.out.printf("%3d", i + j)
            println()
        }
    }
}