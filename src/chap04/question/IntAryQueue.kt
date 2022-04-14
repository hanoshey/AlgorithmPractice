package chap04.question

import java.lang.RuntimeException
import java.lang.OutOfMemoryError
import kotlin.Throws
import chap04.IntStack.OverflowIntStackException
import chap04.IntStack.EmptyIntStackException
import kotlin.jvm.JvmStatic

class IntAryQueue(private var max: Int) {
    private var ptr = 0
    private var que = IntArray(0)

    inner class EmptyIntStackException : RuntimeException()
    inner class OverflowIntStackException : RuntimeException()

    init {
        try {
            que = IntArray(max)
        } catch (e: OutOfMemoryError) {
            max = 0
        }
    }

    @Throws(OverflowIntStackException::class)
    fun inque(x: Int): Int {
        if (ptr >= max) throw OverflowIntStackException()
        return x.also { que[ptr++] = it };
    }

    @Throws(EmptyIntStackException::class)
    fun deque(): Int {
        if (ptr <= 0) throw EmptyIntStackException()
        val temp=que[0]
        for(i in 1..ptr){
            que[i-1]=que[i]
        }
        ptr--
        return temp
    }

    @Throws(EmptyIntStackException::class)
    fun peek(): Int {
        if (ptr <= 0) throw EmptyIntStackException()
        return que[ptr - 1]
    }

    fun indexOf(x: Int): Int {
        for (i in ptr - 1 downTo 0) if (que[i] == x) return i //검색 성공
        return -1 //검색 실패
    }

    fun clear() {
        ptr = 0
    }

    fun capacity(): Int {
        return max
    }

    fun size(): Int {
        return ptr
    }

    val isEmpty: Boolean
        get() = ptr <= 0
    val isFull: Boolean
        get() = ptr >= max

    // 스택 안의 모든 데이터를 바닥 꼭대기 순서로 출력합니다.
    fun dump() {
        if (ptr <= 0) println("스택이 비어 있습니다.") else {
            for (i in 0 until ptr) print(que[i].toString() + " ")
            println()
        }
    }
}