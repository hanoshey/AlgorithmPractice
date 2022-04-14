package chap04

import java.lang.RuntimeException
import java.lang.OutOfMemoryError
import kotlin.Throws
import chap04.IntQueue.OverflowIntQueueException
import chap04.IntQueue.EmptyIntQueueException
import kotlin.jvm.JvmStatic
import chap04.IntQueue

class IntQueue(capacity: Int) {
    private var max: Int
    private var front: Int
    private var rear = 0
    private var num: Int
    private var que = IntArray(0)

    //실행 시 예외 : 큐가 비어 있음
    inner class EmptyIntQueueException : RuntimeException()

    //큐가 가득 참
    inner class OverflowIntQueueException : RuntimeException()

    init {
        front = rear
        num = front
        max = capacity
        try {
            que = IntArray(max)
        } catch (e: OutOfMemoryError) { //생성할 수 없음
            max = 0
        }
    }

    @Throws(OverflowIntQueueException::class)
    fun enque(x: Int): Int {
        if (num >= max) throw OverflowIntQueueException() //큐가 가득 참
        que[rear++] = x
        num++
        if (rear == max) rear = 0
        return x
    }

    @Throws(EmptyIntQueueException::class)
    fun deque(): Int {
        if (num <= 0) throw EmptyIntQueueException()
        val x = que[front++]
        num--
        if (front == max) front = 0
        return x
    }

    @Throws(EmptyIntQueueException::class)
    fun peek(): Int {
        if (num <= 0) throw EmptyIntQueueException() //큐가 비어 있음
        return que[front]
    }

    fun indexOf(x: Int): Int {
        for (i in 0 until num) {
            val idx = (i + front) % max
            if (que[idx] == x) return idx
        }
        return -1
    }

    fun clear() {
        rear = 0
        front = rear
        num = front
    }

    fun capacity(): Int {
        return max
    }

    fun size(): Int {
        return num
    }

    //큐가 비어 있나요?
    val isEmpty: Boolean
        get() = num <= 0
    val isFull: Boolean
        get() = num >= max


    //큐 안의 모든 데이터를 프론트 리어 순으로 출력
    fun dump() {
        if (num <= 0) println("큐가 비어 있습니다.") else {
            for (i in 0 until num) print(que[(i + front) % max].toString() + " ")
            println()
        }
    }
}