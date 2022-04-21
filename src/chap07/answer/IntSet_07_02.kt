package chap07.answer

import java.lang.OutOfMemoryError
import chap07.answer.IntSet_07_01
import java.lang.StringBuffer
import chap07.answer.IntSet_07_02
import chap07.answer.IntSet_07_03
import chap07.answer.IntSet_07_04
import chap07.answer.IntSortedSet_07_05

// 해당 정답 메서드는 소스 코드의 맨 아래쪽에 있습니다.
class IntSet_07_02(  // 집합의 최대 개수
    private var max: Int
) {
    private var num // 집합의 요소 개수
            = 0
    private var set      =     IntArray(0)

    // 생성자
    init {
        try {
            set = IntArray(max) // 집합 배열 생성
        } catch (e: OutOfMemoryError) { // 배열 생성 실패
            max = 0
        }
    }

    // 집합의 최대 개수
    fun capacity(): Int {
        return max
    }

    // 집합의 요소 개수
    fun size(): Int {
        return num
    }

    // 집합에서 n을 검색합니다(index 반환).
    fun indexOf(n: Int): Int {
        for (i in 0 until num) if (set[i] == n) return i // 검색 성공
        return -1 // 검색 실패
    }

    // 집합에 n이 있는지 없는지 확인합니다.
    operator fun contains(n: Int): Boolean {
        return if (indexOf(n) != -1) true else false
    }

    // 집합에 n을 추가합니다.
    fun add(n: Int): Boolean {
        return if (num >= max || contains(n) == true) // 가득 찼거나 이미 n이 존재합니다.
            false else {
            set[num++] = n // 가장 마지막 자리에 추가합니다.
            true
        }
    }

    // 집합에서 n을 삭제합니다.
    fun remove(n: Int): Boolean {
        var idx=0 // n이 저장된 요소의 인덱스
        return if (num <= 0 || indexOf(n).also { idx = it } == -1) // 비어 있거나 이미 n이 존재합니다.
            false else {
            set[idx] = set[--num] // 마지막 요소를 삭제한 곳으로 옮깁니다.
            true
        }
    }

    // 집합 s에 복사합니다.
    fun copyTo(s: IntSet_07_02) {
        val n = if (s.max < num) s.max else num // 복사할 요소 개수
        for (i in 0 until n) s.set[i] = set[i]
        s.num = n
    }

    // 집합 s를 복사합니다.
    fun copyFrom(s: IntSet_07_02) {
        val n = if (max < s.num) max else s.num // 복사할 요소 개수
        for (i in 0 until n) set[i] = s.set[i]
        num = n
    }

    // 집합 s와 같은지 확인합니다.
    fun equalTo(s: IntSet_07_02): Boolean {
        if (num != s.num) // 요소 개수가 같지 않으면
            return false // 집합도 같지 않습니다.
        for (i in 0 until num) {
            var j = 0
            while (j < s.num) {
                if (set[i] == s.set[j]) break
                j++
            }
            if (j == s.num) // set[i]는 s에 포함되지 않습니다.
                return false
        }
        return true
    }

    // 집합 s1과 s2의 합집합을 복사합니다.
    fun unionOf(s1: IntSet_07_02, s2: IntSet_07_02) {
        copyFrom(s1) // 집합 s1을 복사합니다.
        for (i in 0 until s2.num)  // 집합 s2의 요소를 추가합니다.
            add(s2.set[i])
    }

    // "{ a b c }"형식의 문자열로 표현을 바꿉니다.
    override fun toString(): String {
        val temp = StringBuffer("{ ")
        for (i in 0 until num) temp.append(set[i].toString() + " ")
        temp.append("}")
        return temp.toString()
    }

    // ------------------------------ 연습 7-2 ------------------------------//
    // 집합 s와 합집합
    fun add(s: IntSet_07_02?): Boolean {
        var flag = false
        for (i in 0 until num) if (add(set[i]) == true) flag = true
        return flag
    }

    // 집합 s와 교집합
    fun retain(s: IntSet_07_02): Boolean {
        var flag = false
        for (i in 0 until num) if (s.contains(set[i]) == false) {
            remove(set[i])
            flag = true
        }
        return flag
    }

    // 집합 s와 차집합
    fun remove(s: IntSet_07_02): Boolean {
        var flag = false
        for (i in 0 until num) if (s.contains(set[i]) == true) {
            remove(set[i])
            flag = true
        }
        return flag
    } // ------------------------------ 연습 7-2 ------------------------------//
}