package chap04.answer

import java.lang.RuntimeException
import java.lang.OutOfMemoryError
import kotlin.Throws

class Gqueue_04_06<E>(capacity: Int) {
    // 실행할 때 예외：큐가 비어 있음
    class EmptyGqueueException : RuntimeException()

    // 실행할 때 예외：큐가 가득 참
    class OverflowGqueueException : RuntimeException()

    private var max // 큐의 용량
            : Int
    private var num // 현재의 데이터 수
            : Int
    private var front // 맨 앞 커서
            : Int
    private var rear // 맨 뒤 커서
            = 0
    private lateinit var que // 큐의 본체
            : Array<E?>

    // 생성자
    init {
        front = rear
        num = front
        max = capacity
        try {
            que = arrayOfNulls<Any>(max) as Array<E?> // 큐 본체용 배열을 생성
        } catch (e: OutOfMemoryError) {   // 생성할 수 없습니다.
            max = 0
        }
    }

    // 큐에 데이터를 인큐
    @Throws(OverflowGqueueException::class)
    fun enque(x: E): E {
        if (num >= max) throw OverflowGqueueException() // 큐가 가득 참
        que[rear++] = x
        num++
        if (rear == max) rear = 0
        return x
    }

    // 큐에서 데이터를 디큐
    @Throws(EmptyGqueueException::class)
    fun deque(): E? {
        if (num <= 0) throw EmptyGqueueException() // 큐가 비어 있음
        val x = que[front++]
        num--
        if (front == max) front = 0
        return x
    }

    // 큐에서 데이터를 피크(머리데이터를 살펴봄)
    @Throws(EmptyGqueueException::class)
    fun peek(): E? {
        if (num <= 0) throw EmptyGqueueException() // 큐가 비어 있음
        return que[front]
    }

    // 큐에서 x를 검색하여 index(찾지 못하면 -1)를 반환
    fun indexOf(x: E): Int {
        for (i in 0 until num) if (que[(i + front) % max] === x) // 검색성공
            return i + front
        return -1 // 검색실패
    }

    // 큐에서 x를 검색하여 머리부터 몇 번 째인가(찾지 못하면 -1)를 반환
    fun search(x: E): Int {
        for (i in 0 until num) if (que[(i + front) % max] == x) // 검색 성공
            return i + 1
        return -1 // 검색 실패
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

    // 큐 안의 데이터를 머리→꼬리의 차례로 나타냄
    fun dump() {
        if (num <= 0) println("큐가 비었습니다.") else {
            for (i in 0 until num) print(que[(i + front) % max].toString() + " ")
            println()
        }
    }
}