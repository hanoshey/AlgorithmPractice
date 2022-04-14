package chap05.answer

import kotlin.jvm.JvmStatic

// 하노이의 탑(비재귀적으로 구현)
internal object HanoiN_05_07 {
    // 원반을 x기둥에서 y기둥으로 옮김
    fun move(no: Int, x: Int, y: Int) {
        var no = no
        var x = x
        var y = y
        val xstk = IntArray(100)
        val ystk = IntArray(100)
        val sstk = IntArray(100) // 스택
        var ptr = 0 // 스택 포인터
        var sw = 0
        while (true) {
            if (sw == 0 && no > 1) {
                xstk[ptr] = x // x의 값을 푸시
                ystk[ptr] = y // y의 값을 푸시
                sstk[ptr] = sw // sw의 값을 푸시
                ptr++
                no = no - 1
                y = 6 - x - y
                continue
            }
            print("[%d]를 %d기둥에서 %d기둥으로 옮김\n".format(no, x, y))
            if (sw == 1 && no > 1) {
                xstk[ptr] = x // x의 값을 푸시
                ystk[ptr] = y // y의 값을 푸시
                sstk[ptr] = sw // sw의 값을 푸시
                ptr++
                no = no - 1
                x = 6 - x - y
                if (++sw == 2) sw = 0
                continue
            }
            do {
                if (ptr-- == 0) // 스택이 텅 빔
                    return
                x = xstk[ptr] // 값을 저장하고 있는 x를 팝
                y = ystk[ptr] // 값을 저장하고 있는 y를 팝
                sw = sstk[ptr] + 1 // 값을 저장하고 있는 sw를 팝
                no++
            } while (sw == 2)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("하노이의 탑")
        print("원반의 갯수：")
        val n = readLine()!!.toInt()
        move(n, 1, 3) // 1기둥에 쌓인 n 개를 3기둥에 옮김
    }
}