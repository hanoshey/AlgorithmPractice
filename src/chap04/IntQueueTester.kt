package chap04

import chap04.IntQueue.OverflowIntQueueException
import chap04.IntQueue.EmptyIntQueueException
import kotlin.jvm.JvmStatic

import java.util.*

internal object IntQueueTester {
    @JvmStatic
    fun main(args: Array<String>) {
        val s = IntQueue(64)
        while (true) {
            println("현재 데이터 수 : ${s.size()}/${s.capacity()}")
            print("(1)인큐 (2)디큐 (3)피크 (4)덤프 (0)종료 : ")
            val menu = readLine()!!.toInt()
            if (menu == 0) break
            var x: Int
            when (menu) {
                1 -> {
                    print("데이터 : ")
                    x = readLine()!!.toInt()
                    try {
                        s.enque(x)
                    } catch (e: OverflowIntQueueException) {
                        println("큐가 가득 찼습니다.")
                    }
                }
                2 -> try {
                    x = s.deque()
                    println("디큐한 데이터는 ${x}입니다.")
                } catch (e: EmptyIntQueueException) {
                    println("큐가 비어 있습니다.")
                }
                3 -> try {
                    x = s.peek()
                    println("피크한 데이터는 ${x}입니다.")
                } catch (e: EmptyIntQueueException) {
                    println("큐가 비어 있습니다.")
                }
                4 -> s.dump()
            }
        }
    }
}