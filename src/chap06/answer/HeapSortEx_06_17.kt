package chap06.answer

import kotlin.jvm.JvmStatic

internal object HeapSortEx_06_17 {
    // 배열의 요소 a[idx1]과 a[idx2]를 교환
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    // 2의 n 제곱을 구합니다
    fun pow2(n: Int): Int {
        var n = n
        var k = 1
        while (n-- > 0) k *= 2
        return k
    }

    // n개의 스페이스를 출력
    fun dispSpace(n: Int) {
        for (i in 0 until n) print(' ')
    }

    // 힙을 출력
    fun dispHeap(a: IntArray, n: Int) {
        var i = n
        var height = 1 // 트리의 높이
        while (1.let { i = i shr it; i } > 0) height++
        i = 0
        var w = 1
        Loop@ for (level in 0 until height) {
            dispSpace(pow2(height - level) - 3)
            for (k in 0 until w) {
                System.out.printf("%02d", a[i++])
                if (i >= n) break@Loop
                if (k < w - 1) dispSpace(pow2(height - level + 1) - 2)
            }
            println()
            dispSpace(pow2(height - level) - 4)
            for (k in 0 until w) {
                if (2 * k + i < n) print(" ／ ")
                if (2 * k + i + 1 < n) print(" ＼ ")
                if (k < w - 1) dispSpace(pow2(height - level + 1) - 4)
            }
            println()
            w *= 2
        }
        println()
        println()
    }

    // a[left]~a[right]를 힙으로 만들기
    fun downHeap(a: IntArray, left: Int, right: Int) {
        val temp = a[left] // 뿌리
        var child: Int // 큰 쪽의 자식
        var parent: Int // 부모
        parent = left
        while (parent < (right + 1) / 2) {
            val cl = parent * 2 + 1 // 왼쪽 자식
            val cr = cl + 1 // 오른쪽 자식
            child = if (cr <= right && a[cr] > a[cl]) cr else cl // 큰 쪽
            if (temp >= a[child]) break
            a[parent] = a[child]
            parent = child
        }
        a[parent] = temp
    }

    // 힙정렬
    fun heapSort(a: IntArray, n: Int) {
        for (i in (n - 1) / 2 downTo 0) { // a[i]~a[n-1]를 힙으로 만들기
            dispHeap(a, n)
            downHeap(a, i, n - 1)
        }
        for (i in n - 1 downTo 1) {
            swap(a, 0, i) // 최대 요소와 아직 미정렬돈 맨끝 요소를 교환
            dispHeap(a, n)
            downHeap(a, 0, i - 1) // a[0]~a[i-1]를 힙으로 만들기
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("힙정렬 ")
        print("요솟수：")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i]：")
            x[i] = readLine()!!.toInt()
        }
        heapSort(x, nx) // 배열 x를 힙정렬
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx)
            println("x[$i]＝${x[i]}")
    }
}