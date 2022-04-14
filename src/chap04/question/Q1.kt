package chap04.question

import chap04.IntStack
import chap04.IntStack.OverflowIntStackException
import chap04.IntStack.EmptyIntStackException
import kotlin.jvm.JvmStatic

internal object Q1 {
    @JvmStatic
    fun main(args: Array<String>) {
        val s = IntStack(64)
        while (true) {
            println("현재 데이터 수 : ${s.size()}/${s.capacity()}")
            print("(1)푸시 (2)팝 (3)피크 (4)덤프 (5)검색 (6)초기화 (7)빈 행렬인지, 꽉 찬 행렬인지 확인 (0)종료 : ")
            val menu = readLine()!!.toInt()
            if (menu == 0) break
            var x: Int
            when (menu) {
                1 -> {
                    print("데이터 : ")
                    x = readLine()!!.toInt()
                    try {
                        s.push(x)
                    } catch (e: OverflowIntStackException) {
                        println("스택이 가득 찼습니다.")
                    }
                }
                2 -> try {
                    x = s.pop()
                    println("팝한 데이터는 ${x}입니다.")
                } catch (e: EmptyIntStackException) {
                    println("스택이 비어 있습니다.")
                }
                3 -> try {
                    x = s.peek()
                    println("피크한 데이터는 ${x}입니다.")
                } catch (e: EmptyIntStackException) {
                    println("스택이 비어 있습니다.")
                }
                4 -> s.dump()
                5 -> {
                    print("검색할 데이터를 입력하십시오. : ")
                    x = readLine()!!.toInt()
                    if (s.indexOf(x) == -1) {
                        print("데이터가 행렬에 없습니다.")
                    } else {
                        print("데이터는 x[${s.indexOf(x)}]에 있습니다.")
                    }
                }
                6 -> {
                    println("행렬을 초기화합니다.")
                    s.clear()
                }
                7 -> {
                    if (s.isEmpty) println("이 행렬은 비었습니다.")
                    if (s.isFull) println("이 행렬은 꽉 찼습니다.")
                }
            }
        }
    }
}