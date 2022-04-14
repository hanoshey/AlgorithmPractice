package chap04.answer

import java.lang.RuntimeException
import java.lang.OutOfMemoryError
import kotlin.Throws

// 해당 정답 메서드는 소스 코드의 맨 아래쪽에 있습니다.
class IntQueue_04_05(capacity: Int) {
    private var max // 큐의 용량
            : Int
    private var front // 맨 앞 커서
            : Int
    private var rear // 맨 뒤 커서
            = 0
    private var num // 현재의 데이터 수
            : Int
    private var que =IntArray(0)

    // 실행할 때 예외：큐가 비어 있음
    inner class EmptyIntQueueException : RuntimeException()

    // 실행할 때 예외：큐가 가득 참
    inner class OverflowIntQueueException : RuntimeException()

    // 생성자
    init {
        front = rear
        num = front
        max = capacity
        try {
            que = IntArray(max) // 큐 본체용 배열을 생성
        } catch (e: OutOfMemoryError) { // 생성할 수 없습니다.
            max = 0
        }
    }

    // 큐에 데이터를 인큐
    @Throws(OverflowIntQueueException::class)
    fun enque(x: Int): Int {
        if (num >= max) throw OverflowIntQueueException() // 큐가 가득 참
        que[rear++] = x
        num++
        if (rear == max) rear = 0
        return x
    }

    // 큐에서 데이터를 디큐
    @Throws(EmptyIntQueueException::class)
    fun deque(): Int {
        if (num <= 0) throw EmptyIntQueueException() // 큐가 비어 있음
        val x = que[front++]
        num--
        if (front == max) front = 0
        return x
    }

    // 큐에서 데이터를 피크(머리데이터를 살펴봄)
    @Throws(EmptyIntQueueException::class)
    fun peek(): Int {
        if (num <= 0) throw EmptyIntQueueException() // 큐가 비어 있음
        return que[front]
    }

    // 큐에서 x를 검색하여 index(찾지 못하면 -1)를 반환
    fun indexOf(x: Int): Int {
        for (i in 0 until num) {
            val idx = (i + front) % max
            if (que[idx] == x) // 검색성공
                return idx
        }
        return -1 // 검색실패
    }

    // 큐를 비움
    fun clear() {
        rear = 0
        front = rear
        num = front
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

    // 큐 안의 터(이터를 머리→꼬리의 차례로 나타냄
    fun dump() {
        if (num <= 0) println("큐가 비었습니다.") else {
            for (i in 0 until num) print(que[(i + front) % max].toString() + " ")
            println()
        }
    }

    // ------------------------------ 연습5-5 ------------------------------//	
    // 큐에서 x를 검색하여 머리부터 몇 번 째인가(찾지 못하면 0)를 반환
    fun search(x: Int): Int {
        for (i in 0 until num) if (que[(i + front) % max] == x) // 검색성공
            return i + 1
        return 0 // 검색실패
    } // ------------------------------ 연습5-5 ------------------------------//
}