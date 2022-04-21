package chap11.answer

import java.lang.OutOfMemoryError

class ChainHash<K : Any, V : Any>(capacity: Int) {
    // 해시를 구성하는 노드
    internal inner class Node<K, V>(// 키 값을 반환합니다.
        val key: K, val value: V, next: Node<K, V>
    ) {

        var next // 다음 노드에 대한 참조
                : Node<K, V>?

        // 생성자
        init {
            this.next = next
        }

        // 키의 해시값을 반환합니다.
        override fun hashCode(): Int {
            return key.hashCode()
        }
    }

    private var size // 해시 테이블의 크기
            = 0
    private lateinit var table // 해시 테이블
            : Array<Node<K, V>?>

    // 생성자
    init {
        try {
            table = arrayOfNulls(capacity)
            size = capacity
        } catch (e: OutOfMemoryError) {        // 테이블을 생성할 수 없음
            size = 0
        }
    }

    // 해시값을 구함
    fun hashValue(key: K): Int {
        return key.hashCode() % size
    }

    // 키 값 key를 갖는 요소의 검색 (데이터를 반환)
    fun search(key: K): V? {
        val hash = hashValue(key) // 검색할 데이터의 해시값
        var p: Node<K, V>? = table[hash] // 선택 노드
        while (p != null) {
            if (p.key == key) return p.value // 검색 성공
            p = p.next // 다음 노드에 주목
        }
        return null // 검색 실패
    }

    // 키 값 key, 데이터 data를 갖는 요소의  추가
    fun add(key: K, data: V): Int {
        val hash = hashValue(key) // 추가할 데이터의 해시값
        var p: Node<K, V>? = table[hash] // 선택 노드
        while (p != null) {
            if (p.key == key) // 이 키 값은 이미 등록됨
                return 1
            p = p.next // 다음 노드에 주목
        }
        val temp: Node<K, V> = Node(key, data, table[hash])
        table[hash] = temp // 노드를 삽입
        return 0
    }

    // 키 값 key를 갖는 요소의 삭제
    fun remove(key: K): Int {
        val hash = hashValue(key) // 삭제할 데이터의 해시 값
        var p: Node<K, V>? = table[hash] // 선택 노드
        var pp: Node<K, V>? = null // 바로 앞의 선택 노드
        while (p != null) {
            if (p.key == key) {    //  찾으면
                if (pp == null) table[hash] = p.next else pp.next = p.next
                return 0
            }
            pp = p
            p = p.next // 다음 노드를 가리킴
        }
        return 1 // 그 키 값은 없습니다. 
    }

    // 해시 테이블을 덤프
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