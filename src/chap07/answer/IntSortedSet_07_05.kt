package chap07.answer

import java.lang.OutOfMemoryError
import java.lang.StringBuffer


class IntSortedSet_07_05(  // 집합의 용량
    private var max: Int
) {
    private var num // 집합의 요솟수
            = 0
    private var set = IntArray(0)

    // 생성자
    init {
        try {
            set = IntArray(max) // 집합본체용 배열을 생성
        } catch (e: OutOfMemoryError) { // 배열의 생성에 실패
            max = 0
        }
    }

    // 집합에서 n을 검색하여 index를 반환
    // 찾지 못한 경우 (-삽입 포인트-1)를 반환
    fun indexOf(n: Int): Int {
        var pl = 0 // 검색범위 맨 앞의 index
        var pr = n - 1 // 〃 맨 뒤의 index
        do {
            val pc = (pl + pr) / 2 // 중앙요소의 index
            if (set[pc] == n) return pc // 검색성공
            else if (set[pc] < n) pl = pc + 1 // 검색범위를 앞쪽 절반으로 좁힘
            else pr = pc - 1 // 검색범위를 뒤쪽 절반으로 좁힘
        } while (pl <= pr)
        return -pl - 1 // 검색실패
    }

    // 집합에 n이 들어있나요?
    operator fun contains(n: Int): Boolean {
        return indexOf(n) >= 0
    }

    // 집합에 n을 추가
    fun add(n: Int): Boolean {
        var idx = 0
        return if (num >= max || indexOf(n).also { idx = it } >= 0) // 가득 참 또는 들어 있음.
            false else {
            idx = -(idx + 1)
            num++
            for (i in num - 1 downTo idx + 1) set[i] = set[i - 1]
            set[idx] = n
            true
        }
    }

    // 집합에서 n을 삭제
    fun remove(n: Int): Boolean {
        var idx = 0 // n이 저장된 요소의 index
        return if (num <= 0 || indexOf(n).also { idx = it } == -1) // 비어 있음 또는 들어있지 않음
            false else {
            num--
            for (i in idx until num)  // set[idx]를 삭제하고
                set[i] = set[i + 1] // 그 다음 요소를 한 칸 앞으로 옮김
            true
        }
    }

    // 집합의 용량
    fun capacity(): Int {
        return max
    }

    // - 집합의 요솟수
    fun size(): Int {
        return num
    }

    // 집합 s에 복사(s ← this)
    fun copyTo(s: IntSortedSet_07_05) {
        val n = if (s.max < num) s.max else num // 복사하는 요솟수
        for (i in 0 until n) s.set[i] = set[i]
        s.num = n
    }

    // 집합 s를 copy(this ← s)
    fun copyFrom(s: IntSortedSet_07_05) {
        val n = if (max < s.num) max else s.num // copy하는 요솟수
        for (i in 0 until n) set[i] = s.set[i]
        num = n
    }

    // 집합 s와 같은가?
    fun equals(s: IntSortedSet_07_05): Boolean {
        if (num != s.num) // 요솟수가 같지 않으면
            return false // 집합도 같지 않습니다
        for (i in 0 until num) if (set[i] == s.set[i]) return false
        return true
    }

    // 집합 s1과 s2의 합집합을 복사
    fun unionOf(s1: IntSortedSet_07_05, s2: IntSortedSet_07_05) {
        copyFrom(s1) // 집합 s1을 copy
        for (i in 0 until s2.num)  // 집합 s2의 요소를 추가
            add(s2.set[i])
    }

    // "{ a b c }" 형식의 문자열 보기로 변환
    override fun toString(): String {
        val temp = StringBuffer("{ ")
        for (i in 0 until num) temp.append(set[i].toString() + " ")
        temp.append("}")
        return temp.toString()
    }

    // 집합이 비어 있는가?
    val isEmpty: Boolean
        get() = num == 0

    // 집합이 가득 찼는가?
    val isFull: Boolean
        get() = num >= max

    // 집합을 비움(모든 요소를 삭제)
    fun clear() {
        num = 0
    }

    // 집합 s와 합집합
    fun add(s: IntSortedSet_07_05): Boolean {
        var flag = false
        for (i in 0 until s.num) if (add(s.set[i]) == true) flag = true
        return flag
    }

    // 집합 s와 교집합
    fun retain(s: IntSortedSet_07_05): Boolean {
        var flag = false
        for (i in 0 until num) if (s.contains(set[i]) == false) {
            remove(set[i])
            flag = true
        }
        return flag
    }

    // 집합 s와 차집합
    fun remove(s: IntSortedSet_07_05): Boolean {
        var flag = false
        for (i in 0 until num) if (s.contains(set[i]) == true) {
            remove(set[i])
            flag = true
        }
        return flag
    }

    // 집합 s의 부분집합인가요?
    fun isSubsetOf(s: IntSortedSet_07_05): Boolean {
        for (i in 0 until num) {
            var j = 0
            while (j < s.num) {
                if (set[i] == s.set[j]) break
                j++
            }
            if (j == s.num) // set[i]는 s에 포함되지 않음
                return false
        }
        return true
    }

    // 집합 s의 진부분집합인가요?
    fun isProperSubsetOf(s: IntSortedSet_07_05): Boolean {
        return if (num >= s.num) false else s.isSubsetOf(s) // s의 진부분집합이 아님
    }

    // 집합 s1과 s2의 교집합을 복사
    fun intersectionOf(s1: IntSortedSet_07_05, s2: IntSortedSet_07_05) {
        clear()
        for (i in 0 until s1.num) if (s2.contains(s1.set[i])) add(s1.set[i])
    }

    // 집합 s1과 s2의 차집합을 복사
    fun differenceOf(s1: IntSortedSet_07_05, s2: IntSortedSet_07_05) {
        clear()
        for (i in 0 until s1.num) if (!s2.contains(s1.set[i])) add(s1.set[i])
    }
}