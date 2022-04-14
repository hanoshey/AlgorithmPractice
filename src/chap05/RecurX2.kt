package chap05

import chap04.IntStack

internal object RecurX2 {
    fun recur(n: Int) {
        var n = n
        val s = IntStack(n)
        while (true) {
            if (n > 0) {
                s.push(n)//n의 값을 푸시
                n = n - 1
                continue
            }
            if (!s.isEmpty) {//스택이 비어 있지 않다면
                n = s.pop()//저장하고 있던 스택의 값을 팝
                println(n)
                n = n - 2
                continue
            }
            break
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("정수를 입력하세요. : ")
        val x = readLine()!!.toInt()
        recur(x)
    }
}