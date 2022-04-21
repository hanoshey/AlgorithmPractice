package chap09

// 연결 리스트 클래스(배열 커서 버전）


class ArrayLinkedList<E>(capacity: Int) {
    //--- 노드 ---//
    internal inner class Node<E> {
        var data // 데이터
                : E? = null
        var next // 리스트의 뒤쪽포인터
                = 0
        var dnext // 프리 리스트의 뒤쪽포인터
                = 0

        //--- data와 next를 설정 ---//
        operator fun set(data: E, next: Int) {
            this.data = data
            this.next = next
        }
    }

    private var n = Array<Node<E>>(0) { Node() }
    private var size // 리스트 크기(최대 데이터 개수)
            = 0
    private var max // 사용 중인 꼬리 record
            : Int
    private var head // 머리노드
            : Int
    private var crnt // 선택 노드
            : Int
    private var deleted // 프리 리스트의 머리노드
            : Int

    //--- 생성자(constructor) ---//
    init {
        deleted = NULL
        max = deleted
        crnt = max
        head = crnt
        try {
            n = Array(capacity){Node()}
            for (i in 0 until capacity) n[i] = Node()
            size = capacity
        } catch (e: OutOfMemoryError) {        // 배열 생성에 실패
            size = 0
        }
    }// 프리 리스트에서

    // 머리 rec을 꺼냄
// 새 record를 사용
    // 크기 넘침(over)
// 삭제 record가 존재하지 않음
    //--- 다음에 삽입하는 record의 인덱스를 구함 ---//
    private val insertIndex: Int
        private get() = if (deleted == NULL) {                    // 삭제 record가 존재하지 않음
            if (max < size) ++max // 새 record를 사용
            else NULL // 크기 넘침(over)
        } else {
            val rec = deleted // 프리 리스트에서
            deleted = n[rec].dnext // 머리 rec을 꺼냄
            rec
        }

    //--- record idx를 프리 리스트에 등록 ---//
    private fun deleteIndex(idx: Int) {
        if (deleted == NULL) {                    // 삭제 record가 존재하지 않음
            deleted = idx // idx를 프리 리스트의
            n[idx].dnext = NULL // 머리에 등록
        } else {
            val rec = deleted // idx를 프리 리스트의
            deleted = idx // 머리에 삽입
            n[rec].dnext = rec
        }
    }

    //--- 노드를 검색 ---//
    fun search(obj: E, c: Comparator<in E>): E? {
        var ptr = head // 현재 스캔 중인 노드
        while (ptr != NULL) {
            if (c.compare(obj, n[ptr].data) == 0) {
                crnt = ptr
                return n[ptr].data // 검색 성공
            }
            ptr = n[ptr].next // 뒤쪽 노드 선택
        }
        return null // 검색 실패
    }

    //--- 머리노드 삽입 ---//
    fun addFirst(obj: E) {
        val ptr = head // 삽입 전의 머리노드
        val rec = insertIndex
        if (rec != NULL) {
            crnt = rec
            head = crnt // 제 rec 번째 레코드에 삽입
            n[head].set(obj, ptr)
        }
    }

    //--- 꼬리노드 삽입 ---//
    fun addLast(obj: E) {
        if (head == NULL) // 리스트가 비어있으면
            addFirst(obj) // 머리에 삽입
        else {
            var ptr = head
            while (n[ptr].next != NULL) ptr = n[ptr].next
            val rec = insertIndex
            if (rec != NULL) {                        // 제 rec 번째 레코드에 삽입
                crnt = rec
                n[ptr].next = crnt
                n[rec].set(obj, NULL)
            }
        }
    }

    //--- 머리노드 삭제 ---//
    fun removeFirst() {
        if (head != NULL) {                            // 리스트가 비어있지 않으면
            val ptr: Int = n[head].next
            deleteIndex(head)
            crnt = ptr
            head = crnt
        }
    }

    //--- 꼬리노드 삭제 ---//
    fun removeLast() {
        if (head != NULL) {
            if (n[head].next == NULL) // 노드가 하나만 있으면
                removeFirst() // 머리노드 삭제
            else {
                var ptr = head // 스캔 중인 노드
                var pre = head // 스캔 중인 노드의 앞쪽노드
                while (n[ptr].next != NULL) {
                    pre = ptr
                    ptr = n[ptr].next
                }
                n[pre].next = NULL // pre는 삭제 뒤의 꼬리 노드
                deleteIndex(pre)
                crnt = pre
            }
        }
    }

    //--- 레코드 p를 삭제 ---//
    fun remove(p: Int) {
        if (head != NULL) {
            if (p == head) // p가 머리 노드이면
                removeFirst() // 머리노드 삭제
            else {
                var ptr = head
                while (n[ptr].next != p) {
                    ptr = n[ptr].next
                    if (ptr == NULL) return  // p가 리스트에 없음
                }
                n[ptr].next = NULL
                deleteIndex(ptr)
                n[ptr].next = n[p].next
                crnt = ptr
            }
        }
    }

    //--- 선택 노드 삭제 ---//
    fun removeCurrentNode() {
        remove(crnt)
    }

    //--- 전체 노드 삭제 ---//
    fun clear() {
        while (head != NULL) // 비게 될 때까지
            removeFirst() // 머리 노드 삭제
        crnt = NULL
    }

    //--- 선택 노드를 하나 뒤쪽으로 진행 ---//
    operator fun next(): Boolean {
        if (crnt == NULL || n[crnt].next == NULL) return false // 나아갈 수 없음
        crnt = n[crnt].next
        return true
    }

    //--- 선택 노드 표시 ---//
    fun printCurrentNode() {
        if (crnt == NULL) println("선택 노드가 없습니다.") else println(n[crnt].data)
    }

    //--- 전체 노드 표시 ---//
    fun dump() {
        var ptr = head
        while (ptr != NULL) {
            println(n[ptr].data)
            ptr = n[ptr].next
        }
    }

    companion object {
        private const val NULL = -1 // 뒤쪽노드가 없음 / 리스트가 가득 참
    }
}
