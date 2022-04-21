package chap09

class LinkedList<E> {
    class Node<E>(val data: E, var next: Node<E>?)

    private var head: Node<E>? = null
    private var crnt: Node<E>? = null
    fun LinkedList() {
        crnt = null
        head = crnt
    }

    fun search(obj: E, c: Comparator<in E>): E? {
        var ptr = head
        while (ptr != null) {
            if (c.compare(obj, ptr.data) == 0) {
                crnt = ptr
                return ptr.data
            }
            ptr = ptr.next//다음 노드를 선택
        }
        return null
    }

    fun addFirst(obj: E) {
        val ptr: Node<E>? = head
        crnt = Node<E>(obj, ptr)
        head = crnt
    }

    fun addLast(obj: E) {
        if (head == null)
            addFirst(obj)//리스트가 비어있으면 머리에 삽입
        else {
            var ptr: Node<E>? = head
            while (ptr!!.next != null)
                ptr = ptr.next
            crnt = Node<E>(obj, null)
            ptr.next = crnt
        }
    }

    fun removeFirst() {
        if (head != null) {
            crnt = head!!.next
            head = crnt
        }
    }

    fun removeLast() {
        if (head != null) {
            if (head!!.next == null)
                removeFirst()
            else {
                var ptr = head//스캔 중인 노드
                var pre = head//스캔 중인 노드의 앞쪽 노드
                while (ptr!!.next != null) {
                    pre = ptr
                    ptr = ptr.next
                }
                pre!!.next//pre는 삭제 후의 꼬리 노드
                crnt = pre
            }
        }
    }

    fun remove(p: Node<E>?) {
        if (head != null) {
            if (p == head)
                removeFirst()
            else {
                var ptr = head
                while (ptr!!.next != p) {
                    ptr = ptr.next
                    if (ptr == null) return
                }
                ptr.next = p!!.next
                crnt = ptr
            }
        }
    }

    fun removeCurrentNode() = remove(crnt)//선택 노드를 삭제
    fun clear() {
        while (head != null)
            removeFirst()
        crnt = null
    }

    fun next(): Boolean {
        if (crnt == null || crnt!!.next == null)
            return false
        crnt = crnt!!.next
        return true
    }
    fun printCurrentNode(){
        if(crnt==null)
            println("선택한 노드가 없습니다.")
        else
            println(crnt!!.data)
    }
    fun dump(){
        var ptr=head
        while(ptr!=null){
            println(ptr.data)
            ptr=ptr.next
        }
    }

}