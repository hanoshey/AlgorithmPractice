package chap09

class DoubleLinkedList<E> {
    //--- 노드 ---//
    inner class Node<E> {
        var data // 데이터
                : E?
        var prev // 앞쪽포인터(앞쪽 노드에 대한 참조)
                : Node<E>
        var next // 뒤쪽포인터(뒤쪽 노드에 대한 참조)
                : Node<E>

        //--- 생성자(constructor) ---//
        constructor() {
            data = null
            next = this
            prev = next
        }

        //--- 생성자(constructor) ---//
        constructor(obj: E, prev: Node<E>, next: Node<E>) {
            data = obj
            this.prev = prev
            this.next = next
        }
    }

    private val head // 머리 포인터(참조하는 곳은 더미노드)
            : Node<E>
    private var crnt // 선택 포인터
            : Node<E>

    //--- 생성자(constructor) ---//
    init {
        crnt = Node()
        head = crnt // 더미 노드를 생성
    }

    //--- 리스트가 비어있는가? ---//
    val isEmpty: Boolean
        get() = head.next === head

    //--- 노드를 검색 ---//
    fun search(obj: E, c: Comparator<in E>): E? {
        var ptr: Node<E> = head.next // 현재 스캔 중인 노드
        while (ptr !== head) {
            if (c.compare(obj, ptr.data) == 0) {
                crnt = ptr
                return ptr.data // 검색 성공
            }
            ptr = ptr.next // 뒤쪽 노드에 주목
        }
        return null // 검색 실패
    }

    //--- 선택 노드 표시 ---//
    fun printCurrentNode() {
        if (isEmpty) println("선택 노드가 없습니다.") else println(crnt.data)
    }

    //--- 전체 노드 표시 ---//
    fun dump() {
        var ptr: Node<E> = head.next // 더미 노드의 뒤쪽 노드
        while (ptr !== head) {
            println(ptr.data)
            ptr = ptr.next
        }
    }

    //--- 전체 노드 역순 표시 ---//
    fun dumpReverse() {
        var ptr: Node<E> = head.prev // 더미 노드의 앞쪽 노드
        while (ptr !== head) {
            println(ptr.data)
            ptr = ptr.prev
        }
    }

    //--- 선택 노드를 하나 뒤쪽으로 진행 ---//
    fun next(): Boolean {
        if (isEmpty || crnt.next === head) return false // 나아갈 수 없음
        crnt = crnt.next
        return true
    }

    //--- 선택 노드를 하나 앞쪽으로 진행 ---//
    fun prev(): Boolean {
        if (isEmpty || crnt.prev === head) return false // 나아갈 수 없음
        crnt = crnt.prev
        return true
    }

    //--- 선택 노드 바로 뒤에 노드 삽입 ---//
    fun add(obj: E) {
        val node: Node<E> = Node(obj, crnt, crnt.next)
        crnt.next.prev = node
        crnt.next = crnt.next.prev
        crnt = node
    }

    //--- 머리 노드 삽입 ---//
    fun addFirst(obj: E) {
        crnt = head // 더미 노드 head의 바로 뒤에 삽입
        add(obj)
    }

    //--- 꼬리 노드 삽입 ---//
    fun addLast(obj: E) {
        crnt = head.prev // 꼬리 노드head.prev 바로 뒤에 삽입
        add(obj)
    }

    //--- 선택 노드 삭제 ---//
    fun removeCurrentNode() {
        if (!isEmpty) {
            crnt.prev.next = crnt.next
            crnt.next.prev = crnt.prev
            crnt = crnt.prev
            if (crnt === head) crnt = head.next
        }
    }

    //--- 노드p 삭제 ---//
    fun remove(p: Node<*>) {
        var ptr: Node<E> = head.next
        while (ptr !== head) {
            if (ptr === p) {                                // p를 찾았음
                crnt = p
                removeCurrentNode()
                break
            }
            ptr = ptr.next
        }
    }

    //--- 머리 노드 삭제 ---//
    fun removeFirst() {
        crnt = head.next // 머리 노드 head.next를 삭제
        removeCurrentNode()
    }

    //--- 꼬리 노드 삭제 ---//
    fun removeLast() {
        crnt = head.prev // 꼬리 노드 head.prev를 삭제
        removeCurrentNode()
    }

    //--- 전체 노드 삭제 ---//
    fun clear() {
        while (!isEmpty) // 비게 될 때까지
            removeFirst() // 머리노드 삭제
    }
}