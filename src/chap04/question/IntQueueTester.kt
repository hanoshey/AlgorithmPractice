package chap04.question

import chap04.IntStack.OverflowIntStackException
import chap04.IntStack.EmptyIntStackException
import java.util.*
import kotlin.jvm.JvmStatic

internal object IntQueueTester {
    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        val s = IntAryQueue(64)
        while (true) {
            println("현재 데이터 수 : " + s.size() + "/" + s.capacity())
            print("(1)인큐 (2)디큐 (3)피크 (4)덤프 (0)종료 : ")
            val menu = stdIn.nextInt()
            if (menu == 0) break
            var x: Int
            when (menu) {
                1 -> {
                    print("데이터 : ")
                    x = stdIn.nextInt()
                    try {
                        s.inque(x)
                    } catch (e: OverflowIntStackException) {
                        println("스택이 가득 찼습니다.")
                    }
                }
                2 -> try {
                    x = s.deque()
                    println("디큐한 데이터는 " + x + "입니다.")
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