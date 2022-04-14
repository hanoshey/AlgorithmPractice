package chap04.answer

import java.lang.RuntimeException
import java.lang.OutOfMemoryError
import kotlin.Throws

// int형 큐(링 버퍼(ring buffer)를 사용하지 않음)
class IntAryQueue_04_04(  // 큐의 용량
    private var max: Int
) {
    // 실행할 때 예외：큐가 비어 있음
    inner class EmptyIntAryQueueException : RuntimeException()

    // 실행할 때 예외：큐가 가득 참
    inner class OverflowIntAryQueueException : RuntimeException()

    private var num // 현재의 데이터 수
            = 0
    private var que= IntArray(0)

    // 생성자
    init {
        try {
            que = IntArray(max) // 큐 본체용 배열을 생성
        } catch (e: OutOfMemoryError) {   // 생성할 수 없습니다.
            max = 0
        }
    }

    // 큐에 데이터를 인큐
    @Throws(OverflowIntAryQueueException::class)
    fun enque(x: Int): Int {
        if (num >= max) throw OverflowIntAryQueueException() // 큐가 가득 참
        que[num++] = x
        return x
    }

    // 큐에서 데이터를 디큐
    @Throws(EmptyIntAryQueueException::class)
    fun deque(): Int {
        if (num <= 0) throw EmptyIntAryQueueException() // 큐가 비어 있음
        val x = que[0]
        for (i in 0 until num - 1) que[i] = que[i + 1]
        num--
        return x
    }

    // 큐에서 데이터를 피크(머리 데이터를 살펴봄)
    @Throws(EmptyIntAryQueueException::class)
    fun peek(): Int {
        if (num <= 0) throw EmptyIntAryQueueException() // 큐가 비어 있음
        return que[num - 1]
    }

    // 큐에서 x를 검색하여 index(찾지 못하면 -1)를 반환
    fun indexOf(x: Int): Int {
        for (i in 0 until num) if (que[i] == x) // 검색성공
            return i
        return -1 // 검색실패
    }

    // 큐를 비움
    fun clear() {
        num = 0
    }

    // 큐의 용량을 반환
    fun capacity(): Int {
        return max
    }

    // 큐에 쌓인 데이터 수를 반환
    fun size(): Int {
        return num
    }

    // 큐가 비어 있는가?
    val isEmpty: Boolean
        get() = num <= 0

    // 큐가 가득 찼는가?
    val isFull: Boolean
        get() = num >= max

    // 큐 안의 데이터를 머리→꼬리의 차례로 출력함
    fun dump() {
        if (num <= 0) println("큐가 비었습니다.") else {
            for (i in 0 until num) print(que[i].toString() + " ")
            println()
        }
    }
}