package chap11

import java.lang.OutOfMemoryError

// 체인법에 의한 해시
class ChainHash<K, V>(capacity: Int) {
    //--- 해시를 구성하는 노드 ---//
    internal inner class Node<K, V>(//--- 키값을 반환 ---//
        val key // 키값
        : K, //--- 데이터를 반환 ---//
        val value // 데이터
        : V, next: Node<K, V>
    ) {

        var next // 뒤쪽 포인터(뒤쪽 노드에 대한 참조)
                : Node<K, V>

        //--- 생성자(constructor) ---//
        init {
            this.next = next
        }

        //--- 키의 해시값을 반환 ---//
        override fun hashCode(): Int {
            return key.hashCode()
        }
    }

    private var size // 해시 테이블의 크기
            = 0
    private var table= arrayOfNulls<Node<K, V>>(capacity)

    //--- 생성자(constructor) ---//
    init {
        size = try {
            capacity
        } catch (e: OutOfMemoryError) {        // 테이블을 생성할 수 없음
            0
        }
    }

    //--- 해시값을 구함 ---//
    fun hashValue(key: K): Int {
        return key.hashCode() % size
    }

    //--- 키값이 key인 요소를 검색(데이터를 반환) ---//
    fun search(key: K): V? {
        val hash = hashValue(key) // 검색할 데이터의 해시값
        var p: Node<K, V>? = table[hash] // 선택 노드
        while (p != null) {
            if (p.key == key) return p.value // 검색 성공
            p = p.next // 다음 노드를 선택
        }
        return null // 검색 실패
    }

    //--- 키값이 key인 데이터를 data의 요소로 추가 ---//
    fun add(key: K, data: V): Int {
        val hash = hashValue(key) // 추가할 데이터의 해시값
        var p: Node<K, V>? = table[hash] // 선택 노드
        while (p != null) {
            if (p.key == key) // 키값이 이미 등록됨
                return 1
            p = p.next // 다음 노드를 선택
        }
        val temp: Node<K, V> = Node<K, V>(key, data, table[hash]!!)
        table[hash] = temp // 노드 삽입
        return 0
    }

    //--- 키값이 key인 요소를 삭제 ---//
    fun remove(key: K): Int {
        val hash = hashValue(key) // 삭제할 데이터의 해시값
        var p: Node<K, V>? = table[hash] // 선택 노드
        var pp: Node<K, V>? = null // 바로 앞의 선택 노드
        while (p != null) {
            if (p.key == key) {    //찾으면
                if (pp == null) table[hash] = p.next else pp.next = p.next
                return 0
            }
            pp = p
            p = p.next // 다음 노드를 선택
        }
        return 1 // 찾는 키값이 없음
    }

    //--- 해시 테이블을 덤프(dump) ---//
    fun dump() {
        for (i in 0 until size) {
            var p: Node<K, V>? = table[i]
            System.out.printf("%02d  ", i)
            while (p != null) {
                System.out.printf("→ %s (%s)  ", p.key, p.value)
                p = p.next
            }
            println()
        }
    }
}