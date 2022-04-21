package chap10.answer

import chap10.answer.BinTreeTester_10_03
import java.util.Comparator
import kotlin.jvm.JvmStatic

// 이진검색트리
// 해당 정답 메서드는 소스 코드의 맨 아래쪽에 있습니다.
class BinTree_10_01<K, V>     // 생성자
    () {
    // 노드
    internal class Node<K, V>     // 생성자
        (// 키 값을 반환
        var key // 키 값
        : K, // 데이터를 반환
        var value // 데이터
        : V, // 왼쪽 자식 노드
        var left: Node<K, V>?, // 오른쪽 자식 노드
        var right: Node<K, V>?
    ) {

        // 데이터를 출력
        fun print() {
            println(value)
        }
    }

    private var root // 루트
            : Node<K, V>? = null
    private var comparator: Comparator<in K>? = null // 비교자

    // 생성자
    constructor(c: Comparator<in K>?) : this() {
        comparator = c
    }

    // 두 킷값을 비교
    private fun comp(key1: K, key2: K): Int {
        return if (comparator == null) (key1 as Comparable<K>).compareTo(key2) else comparator!!.compare(key1, key2)
    }

    // 키에 의한 검색
    fun search(key: K): V? {
        var p = root // 루트에 주목
        while (true) {
            if (p == null) // 더 이상 진행하지 않으면
                return null // 검색 실패
            val cond = comp(key, p.key) // key와 노드 p의 키를 비교
            p = if (cond == 0) // 같으면
                return p.value // 검색 성공
            else if (cond < 0) // key 쪽이 작으면
                p.left // 왼쪽 서브 트리에서 검색
            else  // key 쪽이 크면
                p.right // 오른쪽 서브 트리에서 검색
        }
    }

    // node를 루트로 하는 서브 트리에 노드<K,V>를 삽입
    private fun addNode(node: Node<K, V>, key: K, data: V) {
        val cond = comp(key, node.key)
        if (cond == 0) return  // key가 이진검색트리에 이미 있음
        else if (cond < 0) {
            if (node.left == null) node.left = Node(key, data, null, null) else addNode(
                node.left!!,
                key,
                data
            ) // 왼쪽 서브 트리에 주목
        } else {
            if (node.right == null) node.right = Node(key, data, null, null) else addNode(
                node.right!!,
                key,
                data
            ) // 오른쪽 서브 트리에 주목
        }
    }

    // 노드를 삽입
    fun add(key: K, data: V) {
        if (root == null) root = Node(key, data, null, null) else addNode(root!!, key, data)
    }

    // 키 값이 key인 노드를 삭제
    fun remove(key: K): Boolean {
        var p = root // 스캔 중인 노드
        var parent: Node<K, V>? = null // 스캔 중인 노드의 부모 노드
        var isLeftChild = true // p는 parent의 왼쪽 자식 노드인가?
        while (true) {
            if (p == null) // 더 이상 진행하지 않으면
                return false // 그 키 값은 없습니다.
            val cond = comp(key, p.key) // key와 노드 p의 키 값을 비교
            if (cond == 0) // 같으면
                break // 검색 성공
            else {
                parent = p // 가지로 내려가기 전에 부모를 설정
                if (cond < 0) { // key 쪽이 작으면
                    isLeftChild = true // 왼쪽 자식으로 내려감
                    p = p.left // 왼쪽 서브트리에서 검색
                } else { // key 쪽이 크면
                    isLeftChild = false // 오른쪽 자식으로 내려감
                    p = p.right // 오른쪽 서브 트리에서 검색
                }
            }
        }
        if (p!!.left == null) { // p에는 왼쪽 자식이 없음
            if (p === root) root = p.right else if (isLeftChild) parent!!.left = p.right // 부모의 왼쪽 포인터가 오른쪽 자식을 가리킴
            else parent!!.right = p.right // 부모의 오른쪽 포인터가 오른쪽 자식을 가리킴
        } else if (p.right == null) { // p에는오른쪽 자식이 없음
            if (p === root) root = p.left else if (isLeftChild) parent!!.left = p.left // 부모의 왼쪽 포인터가 왼쪽 자식을 가리킴
            else parent!!.right = p.left // 부모의 오른쪽 포인터가 왼쪽 자식을 가리킴
        } else {
            parent = p
            var left = p.left // 서브 트리 가운데 가장 큰 노드
            isLeftChild = true
            while (left!!.right != null) { // 가장 큰 노드 left를 검색
                parent = left
                left = left.right
                isLeftChild = false
            }
            p.key = left.key // left의 키 값을 p로 옮김
            p.value = left.value // left의 데이터를 p로 옮김
            if (isLeftChild) parent!!.left = left.left // left를 삭제
            else parent!!.right = left.left // left를 삭제
        }
        return true
    }

    // node를 루트로 하는 서브 트리의 노드를 키 값의 오름차순으로 출력
    private fun printSubTree(node: Node<*, *>?) {
        if (node != null) {
            printSubTree(node.left) // 왼쪽 서브 트리를 키 값의 오름차순으로 출력
            println(node.key.toString() + " " + node.value) // node를 출력
            printSubTree(node.right) // 오른쪽 서브 트리를 키 값의 오름차순으로 출력
        }
    }

    // 모든 노드를 킷값의 오름차순으로 출력
    fun print() {
        printSubTree(root)
    }

    //----------------------- 연습문제 10-1 --------------------------//
    // node를 뿌리로 하는 서브트리의 노드를 키값의 내림차순으로 출력함
    private fun printSubTreeR(node: Node<*, *>?) {
        if (node != null) {
            printSubTreeR(node.right) // 오른쪽 서브트리를 키값의 오름차순으로 나타냄
            println(node.key.toString() + " " + node.value.toString()) // node를 나타냄
            printSubTreeR(node.left) // 왼쪽 서브트리를 키값의 오름차순으로 나타냄
        }
    }

    // 모든 노드를 키값의 내림차순으로 출력함
    fun printRerverse() {
        printSubTreeR(root)
    } //----------------------- 연습문제 10-1 --------------------------//
}