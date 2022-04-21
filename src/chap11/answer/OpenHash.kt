package chap11.answer

import java.lang.OutOfMemoryError
import chap11.answer.ChainHashTester_11_01
import kotlin.jvm.JvmStatic
import chap11.answer.OpenHashTester_11_01

// 오픈 주소법에 의한 해시
class OpenHash<K, V>(size: Int) {
    // 버킷의 상태
    internal enum class Status {
        OCCUPIED, EMPTY, DELETED
    }

    // {데이터 저장, 비어 있음, 삭제 마침}
    // 버킷
    internal class Bucket<K, V> {
        // 키 값을 반환합니다.
        var key // 키 값
                : K? = null
            private set

        // 데이터를 반환합니다.
        var value // 데이터
                : V? = null
            private set
        var stat : Status

        // 생성자
        init {
            stat = Status.EMPTY // 버킷은 비어 있음
        }

        // 모든 필드에 값을 설정합니다.
        operator fun set(key: K, data: V, stat: Status) {
            this.key = key // 키 값
            value = data // 데이터
            this.stat = stat // 상태
        }

        // 상태를 설정합니다.
        fun setStat(stat: Status) {
            this.stat = stat
        }

        // 키의 해시 값을 반환합니다.
        override fun hashCode(): Int {
            return key.hashCode()
        }
    }

    private var size // 해시 테이블의 크기
            = 0
    private val table // 해시 테이블
            : Array<Bucket<K, V>>

    // 생성자
    init {
        try {
            table = arrayOfNulls<Bucket<*, *>>(size)
            for (i in 0 until size) table[i] = Bucket<K, V>()
            this.size = size
        } catch (e: OutOfMemoryError) {        // 테이블을 생성할 수 없음
            this.size = 0
        }
    }

    // 해시 값을 구함
    fun hashValue(key: Any): Int {
        return key.hashCode() % size
    }

    // 재해시값을 구함
    fun rehashValue(hash: Int): Int {
        return (hash + 1) % size
    }

    // 키 값 key를 갖는 버킷의 검색
    private fun searchNode(key: K): Bucket<K, V>? {
        var hash = hashValue(key) // 검색할 데이터의 해시값
        var p = table[hash] // 선택 버킷
        var i = 0
        while (p.stat != Status.EMPTY && i < size) {
            if (p.stat == Status.OCCUPIED && p.key == key) return p
            hash = rehashValue(hash) // 재해시
            p = table[hash]
            i++
        }
        return null
    }

    // 킷값 key를 갖는 요소의 검색 (데이터를 반환)
    fun search(key: K): V? {
        val p = searchNode(key)
        return p?.value
    }

    // 키 값 key, 데이터 data를 갖는 요소의  추가
    fun add(key: K, data: V): Int {
        if (search(key) != null) return 1 // 이 키 값은 이미 등록됨
        var hash = hashValue(key) // 추가할 데이터의 해시 값
        var p = table[hash] // 선택 버킷
        for (i in 0 until size) {
            if (p.stat == Status.EMPTY || p.stat == Status.DELETED) {
                p[key, data] = Status.OCCUPIED
                return 0
            }
            hash = rehashValue(hash) // 재해시
            p = table[hash]
        }
        return 2 // 해시 테이블이 가득 참
    }

    // 키 값 key를 갖는 요소의 삭제
    fun remove(key: K): Int {
        val p = searchNode(key) ?: return 1 // 선택 버킷
        // 이 키 값은 등록되지 않음
        p.setStat(Status.DELETED)
        return 0
    }

    // 해시 테이블을 덤프
    fun dump() {
        for (i in 0 until size) {
            System.out.printf("%02d ", i)
            when (table[i].stat) {
                Status.OCCUPIED -> System.out.printf(
                    "%s (%s)\n",
                    table[i].key, table[i].value
                )
                Status.EMPTY -> println("-- 미등록 --")
                Status.DELETED -> println("-- 삭제 마침 --")
            }
        }
    }
}