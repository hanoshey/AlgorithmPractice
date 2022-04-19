package chap06.answer

import java.lang.RuntimeException
import java.lang.OutOfMemoryError
import kotlin.Throws

// int형 스택
class IntStack(  // 스택 용량
    private var max: Int
) {
    private var ptr // 스택 포인터
            = 0
    private var stk = IntArray(0)

    // 실행 시 예외 : 스택이 비어 있음
    inner class EmptyIntStackException : RuntimeException()

    // 실행 시 예외 : 스택이 가득 참
    inner class OverflowIntStackException : RuntimeException()

    // 생성자
    init {
        try {
            stk = IntArray(max) // 스택 본체용 배열을  생성
        } catch (e: OutOfMemoryError) {        // 생성할 수 없음
            max = 0
        }
    }

    // 스택에 x를 푸시
    @Throws(OverflowIntStackException::class)
    fun push(x: Int): Int {
        if (ptr >= max) throw OverflowIntStackException()
        return x.also { stk[ptr++] = it }
    }

    // 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄)
    @Throws(EmptyIntStackException::class)
    fun pop(): Int {
        if (ptr <= 0) throw EmptyIntStackException()
        return stk[--ptr]
    }

    // 스택에서 데이터를 피크(정상에 있는 데이터를 들여다봄) 
    @Throws(EmptyIntStackException::class)
    fun peek(): Int {
        if (ptr <= 0) throw EmptyIntStackException()
        return stk[ptr - 1]
    }

    // 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 
    fun indexOf(x: Int): Int {
        for (i in ptr - 1 downTo 0)  // 정상 쪽에서 선형 검색
            if (stk[i] == x) return i // 검색 성공
        return -1 // 검색 실패
    }

    // 스택을 비움
    fun clear() {
        ptr = 0
    }

    // 스택의 용량을 반환
    fun capacity(): Int {
        return max
    }

    // 스택에 쌓여 있는 데이터 수를 반환
    fun size(): Int {
        return ptr
    }

    // 스택이 비어 있는가?
    val isEmpty: Boolean
        get() = ptr <= 0

    // 스택이 가득 찼는가?
    val isFull: Boolean
        get() = ptr >= max

    // 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력
    fun dump() {
        if (ptr <= 0) println("스택이 비어 있습니다.") else {
            for (i in 0 until ptr) print("${stk[i]} ")
            println()
        }
    }
}