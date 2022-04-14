package chap04.answer

import java.lang.RuntimeException
import java.lang.OutOfMemoryError
import kotlin.Throws

class Gstack_04_02<E>(  // 스택의 용량
    private var max: Int
) {
    private var ptr // 스택 포인터
            = 0
    private lateinit var stk // 스택 본체
            : Array<E?>

    // 실행할 때 예외：스택이 비어 있음
    class EmptyGstackException : RuntimeException()

    // 실행할 때 예외：스택이 가득 참
    class OverflowGstackException : RuntimeException()

    // 생성자
    init {
        try {
            stk = arrayOfNulls<Any>(max) as Array<E?> // 스택 본체용 배열을 생성
        } catch (e: OutOfMemoryError) { // 생성할 수 없습니다.
            max = 0
        }
    }

    // 스택에 x를 푸시
    @Throws(OverflowGstackException::class)
    fun push(x: E): E {
        if (ptr >= max) throw OverflowGstackException()
        return x.also { stk[ptr++] = it }
    }

    // 스택에서 데이터를 팝 (꼭대기의 데이터를 꺼냄)
    @Throws(EmptyGstackException::class)
    fun pop(): E? {
        if (ptr <= 0) throw EmptyGstackException()
        return stk[--ptr]
    }

    // 스택에서 데이터를 피크(꼭대기의 데이터를 살펴 봄)
    @Throws(EmptyGstackException::class)
    fun peek(): E? {
        if (ptr <= 0) throw EmptyGstackException()
        return stk[ptr - 1]
    }

    // 스택에서 x를 검색하여 index(찾지 못하면 -1)를 반환
    fun indexOf(x: E): Int {
        for (i in ptr - 1 downTo 0)  // 꼭대기쪽부터 선형 검색
            if (stk[i] == x) return i // 검색성공
        return -1 // 검색실패
    }

    // 스택을 비움
    fun clear() {
        ptr = 0
    }

    // 스택의 용량을 반환
    fun capacity(): Int {
        return max
    }

    // 스택에 쌓여있는 데이터 수를 반환
    fun size(): Int {
        return ptr
    }

    // 스택이 비어 있는가?
    val isEmpty: Boolean
        get() = ptr <= 0

    // 스택이 가득 찼는가?
    val isFull: Boolean
        get() = ptr >= max

    // 스택 안의 데이터를 바닥→꼭대기의 차례로 출력함
    fun dump() {
        if (ptr <= 0) println("스택이 비었습니다.") else {
            for (i in 0 until ptr) print(stk[i].toString() + " ")
            println()
        }
    }
}