package chap02

import kotlin.jvm.JvmStatic

internal object IntArrayInit {
    @JvmStatic
    fun main(args: Array<String>) {
        val a = intArrayOf(1, 2, 3, 4, 5) //배열 초기자에 의해 생성
        for (i in a.indices) println("a[" + i + "] = " + a[i])
    }
}