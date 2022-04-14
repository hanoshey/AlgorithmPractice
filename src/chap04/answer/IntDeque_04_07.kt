package chap04.answer

import java.lang.RuntimeException
import java.lang.OutOfMemoryError
import kotlin.Throws

class IntDeque_04_07(capacity: Int) {
    private var max // 덱(deck)의 용량
            : Int
    private var num // 현재의 데이터 수
            : Int
    private var front // 맨 앞 커서
            : Int
    private var rear // 맨 뒤 커서
            = 0
    private var que =IntArray(0)

    // 실행할 때 예외：큐가 비어 있음
    inner class EmptyIntDequeException : RuntimeException()

    // 실행할 때 예외：큐가 가득 참
    inner class OverflowIntDequeException : RuntimeException()

    // 생성자
    init {
        front = rear
        num = front
        max = capacity
        try {
            que = IntArray(max) // 덱(deck)본체용 배열을 생성
        } catch (e: OutOfMemoryError) { // 생성할 수 없습니다
            max = 0
        }
    }

    // 덱(deck)에 데이터를 머리쪽부터 인큐
    @Throws(OverflowIntDequeException::class)
    fun enqueFront(x: Int): Int {
        if (num >= max) throw OverflowIntDequeException() // 덱(deck)이 가득 참
        num++
        if (--front < 0) front = max - 1
        que[front] = x
        return x
    }

    // 덱(deck)에 데이터를 꼬리쪽부터 인큐
    @Throws(OverflowIntDequeException::class)
    fun enqueRear(x: Int): Int {
        if (num >= max) throw OverflowIntDequeException() // 덱(deck)은 가득 참
        que[rear++] = x
        num++
        if (rear == max) rear = 0
        return x
    }

    // 덱(deck)의 머리부터 데이터를 디큐
    @Throws(EmptyIntDequeException::class)
    fun dequeFront(): Int {
        if (num <= 0) throw EmptyIntDequeException() // 덱(deck)이 비어 있음
        val x = que[front++]
        num--
        if (front == max) front = 0
        return x
    }

    // 덱(deck)의 꼬리부터 데이터를 디큐
    @Throws(EmptyIntDequeException::class)
    fun dequeRear(): Int {
        if (num <= 0) throw EmptyIntDequeException() // 덱(deck)이 비어 있음
        num--
        if (--rear < 0) rear = max - 1
        return que[rear]
    }

    // 덱(deck)의 머리부터 데이터를 피크(머리데이터를 살펴봄)
    @Throws(EmptyIntDequeException::class)
    fun peekFront(): Int {
        if (num <= 0) throw EmptyIntDequeException() // 덱(deck)이 비어 있음
        return que[front]
    }

    // 덱(deck)의 꼬리부터 데이터를 피크(꼬리데이터를 살펴봄)
    @Throws(EmptyIntDequeException::class)
    fun peekRear(): Int {
        if (num <= 0) throw EmptyIntDequeException() // 덱(deck)이 비어 있음
        return que[if (rear == 0) max - 1 else rear - 1]
    }

    // 덱(deck)에서 x를 검색하여 index(찾지 못하면 -1)를 반환
    fun indexOf(x: Int): Int {
        for (i in 0 until num) if (que[(i + front) % max] == x) // 검색성공
            return i + front
        return -1 // 검색실패
    }

    // 덱(deck)에서 x를 검색하여 머리부터 몇 번 째인가(찾지 못하면 0)를 반환
    fun search(x: Int): Int {
        for (i in 0 until num) if (que[(i + front) % max] == x) // 검색성공
            return i + 1
        return 0 // 검색실패
    }

    // 덱(deck)을 비움
    fun clear() {
        rear = 0
        front = rear
        num = front
    }

    // 덱(deck)의 용량을 반환
    fun capacity(): Int {
        return max
    }

    // 덱(deck)에 쌓인 데이터 수를 반환
    fun size(): Int {
        return num
    }

    // 덱(deck)이 비어 있는가?
    val isEmpty: Boolean
        get() = num <= 0

    // 덱(deck)이 가득 찼는가?
    val isFull: Boolean
        get() = num >= max

    // 덱(deck)내의 데이터를 머리→꼬리의 차례로 나타냄
    fun dump() {
        if (num <= 0) println("덱(deck)이 비었습니다.") else {
            for (i in 0 until num) print(que[(i + front) % max].toString() + " ")
            println()
        }
    }
}