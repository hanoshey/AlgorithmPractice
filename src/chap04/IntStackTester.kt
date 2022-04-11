package chap04

import chap04.IntStack.OverflowIntStackException
import chap04.IntStack.EmptyIntStackException
import java.util.*
import kotlin.jvm.JvmStatic

internal object IntStackTester {
    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        val s = IntStack(64)
        while (true) {
            println("현재 데이터 수 : " + s.size() + "/" + s.capacity())
            print("(1)푸시 (2)팝 (3)피크 (4)덤프 (0)종료 : ")
            val menu = stdIn.nextInt()
            if (menu == 0) break
            var x: Int
            when (menu) {
                1 -> {
                    print("데이터 : ")
                    x = stdIn.nextInt()
                    try {
                        s.push(x)
                    } catch (e: OverflowIntStackException) {
                        println("스택이 가득 찼습니다.")
                    }
                }
                2 -> try {
                    x = s.pop()
                    println("팝한 데이터는 " + x + "입니다.")
                } catch (e: EmptyIntStackException) {
                    println("스택이 비어 있습니다.")
                }
                3 -> try {
                    x = s.peek()
                    println("피크한 데이터는 " + x + "입니다.")
                } catch (e: EmptyIntStackException) {
                    println("스택이 비어 있습니다.")
                }
                4 -> s.dump()
            }
        }
    }
}