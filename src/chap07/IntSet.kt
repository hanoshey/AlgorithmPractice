package chap07

import java.lang.OutOfMemoryError

class IntSet(private var max: Int) {
    private var num = 0
    private var set = IntArray(0)

    init {
        try {
            set = IntArray(max)
        } catch (e: OutOfMemoryError) {
            max = 0
        }
    }

    fun capacity(): Int {
        return max
    }

    fun size(): Int {
        return num
    }

    fun indexOf(n: Int): Int {
        for (i in 0 until num)
            if (set[i] == n)
                return i//검색 성공
        return -1//검색 실패
    }

    //집합에 n이 있는지 없는지 확인합니다.
    fun contains(n: Int): Boolean {
        return indexOf(n) != -1
    }

    //집합에 n을 추가합니다.
    fun add(n: Int): Boolean {
        return if (num >= max || contains(n))
            false
        else {
            set[num++] = n
            true
        }
    }

    fun remove(n: Int): Boolean {
        val idx = indexOf(n)
        return if (num <= 0 || (idx) == -1)
            false
        else {
            set[idx] = set[--num]
            true
        }
    }

    //집합 s에 복사합니다.
    fun copyTo(s: IntSet) {
        val n = if (s.max < num) s.max else num//복사할 요소 개수
        for (i in 0 until n)
            s.set[i] = set[i]
        s.num = n
    }

    //집합 s를 복사합니다.
    fun copyFrom(s: IntSet) {
        val n = if (max < s.num) max else s.num
        for (i in 0 until n)
            set[i] = s.set[i]
        num = n
    }

    fun equalTo(s: IntSet): Boolean {
        if (num != s.num)
            return false
        for (i in 0 until num) {
            var j = 0
            while (j < s.num) {
                if (set[i] == s.set[j])
                    break
                j++
            }
            if (j == s.num)//set[i]는 s에 포함되지 않습니다.
                return false
        }
        return true
    }

    //집합 s1과 s2의 합집합을 복사합니다.
    fun unionOf(s1: IntSet, s2: IntSet) {
        copyFrom(s1)
        for (i in 0 until s2.num)
            add(s2.set[i])
    }

    override fun toString(): String {
        val temp = StringBuffer("{ ")
        for (i in 0 until num)
            temp.append("${set[i]} ")
        temp.append("}")
        return temp.toString()
    }

}