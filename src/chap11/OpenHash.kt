package chap11

import java.lang.OutOfMemoryError

// 오픈 주소법에 의한 해시
class OpenHash<K, V>(size: Int) {
    //--- 버킷의 상태 ---//
    internal enum class Status {
        OCCUPIED, EMPTY, DELETED
    }

    // {데이터 저장, 비어있음, 삭제 완료}
    //--- 버킷 ---//
    internal class Bucket<K, V> {
        //--- 키값을 반환 ---//
        var key // 키값
                : K? = null
            private set

        //--- 데이터를 반환 ---//
        var value // 데이터
                : V? = null
            private set
        var stat: Status =Status.EMPTY

        //--- 생성자(constructor) ---//

        //--- 모든 필드에 값을 설정 ---//
        operator fun set(key: K, data: V, stat: Status) {
            this.key = key // 키값
            value = data // 데이터
            this.stat = stat // 상태
        }

        //--- 상태를 설정 ---//
        fun setStat(stat: Status) {
            this.stat = stat
        }

        //--- 키의 해시값을 반환 ---//
        override fun hashCode(): Int {
            return key.hashCode()
        }
    }

    private val size // 해시 테이블의 크기
            = 0
    private val table // 해시 테이블
            : Array<Bucket<K, V>>

    //--- 생성자(constructor) ---//
    init {
        try {
            table = arrayOfNulls<Bucket<*, *>>(size)
            for (i in 0 until size) table[i] = Bucket<K, V>()
            this.size = size
        } catch (e: OutOfMemoryError) {        // 테이블을 생성할 수 없음
            this.size = 0
        }
    }

    //--- 해시값을 구함 ---//
    fun hashValue(key: Any): Int {
        return key.hashCode() % size
    }

    //--- 재해시값을 구함 ---//
    fun rehashValue(hash: Int): Int {
        return (hash + 1) % size
    }

    //--- 키값 key를 갖는 버킷 검색 ---//
    private fun searchNode(key: K): Bucket<K, V>? {
        var hash = hashValue(key) // 검색할 데이터의 해시값
        var p = table[hash] // 주목 버킷
        var i = 0
        while (p.stat != Status.EMPTY && i < size) {
            if (p.stat == Status.OCCUPIED && p.key == key) return p
            hash = rehashValue(hash) // 재해시
            p = table[hash]
            i++
        }
        return null
    }

    //--- 키값이 key인 요소를 검색(데이터를 반환)---//
    fun search(key: K): V? {
        val p = searchNode(key)
        return p?.value
    }

    //--- 키값이 key인 데이터를 data의 요소로 추가 ---//
    fun add(key: K, data: V): Int {
        if (search(key) != null) return 1 // 키값이 이미 등록되어 있음
        var hash = hashValue(key) // 추가할 데이터의 해시값
        var p = table[hash] // 주목 버킷
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

    //--- 키값이 key인 요소를 삭제 ---//
    fun remove(key: K): Int {
        val p = searchNode(key) ?: return 1 // 주목 버킷
        // 이 키값은 등록되어 있지 않음
        p.setStat(Status.DELETED)
        return 0
    }

    //--- 해시 테이블을 덤프(dump) ---//
    fun dump() {
        for (i in 0 until size) {
            System.out.printf("%02d ", i)
            when (table[i].stat) {
                Status.OCCUPIED -> System.out.printf(
                    "%s (%s)\n",
                    table[i].key, table[i].value
                )
                Status.EMPTY -> println("-- 비어있음 --")
                Status.DELETED -> println("-- 삭제 완료 --")
            }
        }
    }
}