package chap04

import java.util.*
import kotlin.jvm.JvmStatic

internal object LastNElements {
    @JvmStatic
    fun main(args: Array<String>) {
        val N = 10
        val a = IntArray(N)
        var cnt = 0
        var retry: Int
        println("정수를 입력하세요.")
        do {
            print("%d번째 정수 : ".format(cnt + 1))
            a[cnt++ % N] = readLine()!!.toInt()
            print("계속 할까요? (예.1/아니오.0)")
            retry = readLine()!!.toInt()
        } while (retry == 1)
        var i = cnt - N
        if (i < 0) i = 0
        while (i < cnt) {
            print("%2d번째 정수=%d\n".format(i + 1, a[i % N]))
            i++
        }
    }
}