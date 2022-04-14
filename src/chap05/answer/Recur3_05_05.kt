package chap05.answer

import kotlin.jvm.JvmStatic

// 메소드 recur3의 비재귀적구현
internal object Recur3_05_05 {
    // 메소드 recur의 비재귀적 구현
    fun recur3(n: Int) {
        var n = n
        val nstk = IntArray(100)
        val sstk = IntArray(100)
        var ptr = -1
        var sw = 0
        while (true) {
            if (n > 0) {
                ptr++
                nstk[ptr] = n
                sstk[ptr] = sw
                if (sw == 0) n -= 1 else if (sw == 1) {
                    n -= 2
                    sw = 0
                }
                continue
            }
            do {
                n = nstk[ptr]
                sw = sstk[ptr--] + 1
                if (sw == 2) {
                    println(n)
                    if (ptr < 0) return
                }
            } while (sw == 2)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("정수를 입력하세요.：")
        val x = readLine()!!.toInt()
        recur3(x)
    }
}