package chap04.answer

import chap04.IntStack
import java.util.*

internal object IntStackTesterEx_04_01 {
    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        val s = IntStack(100) // 최대 100개를 푸시할 수 있는 스택
        while (true) {
            println("현재의 데이터 수：" + s.size() + " / " + s.capacity())
            print("(1)푸시 (2)팝 (3)피크 " + "(4)덤프 (5)검색 (6)비움  " + "(7)정보표시 (0)종료：")
            val menu = stdIn.nextInt()
            if (menu == 0) break
            var x: Int
            when (menu) {
                1 -> {
                    print("데이터：")
                    x = stdIn.nextInt()
                    try {
                        s.push(x)
                    } catch (e: IntStack.OverflowIntStackException) {
                        println("스택이 가득 찼습니다.")
                    }
                }
                2 -> try {
                    x = s.pop()
                    println("팝한 데이터는 " + x + "입니다.")
                } catch (e: IntStack.EmptyIntStackException) {
                    println("스택이 비었습니다.")
                }
                3 -> try {
                    x = s.peek()
                    println("피크한 데이터는 " + x + "입니다.")
                } catch (e: IntStack.EmptyIntStackException) {
                    println("스택이 비었습니다.")
                }
                4 -> s.dump()
                5 -> {
                    print("찾는 데이터：")
                    x = stdIn.nextInt()
                    val n = s.indexOf(x)
                    if (n >= 0) println("꼭대기부터 " + (s.size() - n) + "번 째에 있습니다.") else println("그 데이터가 없습니다.")
                }
                6 -> s.clear()
                7 -> {
                    println("용량：" + s.capacity())
                    println("데이터 수：" + s.size())
                    println("비어 " + if (s.isEmpty) "있습니다." else "있지 않습니다.")
                    println("가득 " + if (s.isFull) "찼습니다." else "차지 않았습니다.")
                }
            }
        }
    }
}