package chap06

internal object HeapSort {
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    //a[left]~a[right]를 힙으로 만듭니다.
    fun downHeap(a: IntArray, left: Int, right: Int) {
        val temp = a[left]//루트
        var child: Int//큰 값을 가진 노드
        var parent = left//부모
        while (parent < (right + 1) / 2) {
            val cl = parent * 2 + 1// 왼쪽 자식
            val cr = cl + 1//오른쪽 자식
            child = if (cr <= right && a[cr] > a[cl]) cr else cl//큰 값을 가진 노드를 자식에 대입
            if (temp >= a[child])
                break
            a[parent] = a[child]
            parent = child
        }
        a[parent] = temp
    }

    fun heapSort(a: IntArray, n: Int) {
        for (i in (n - 1) / 2 downTo 0)//a[i]~a[n-1]을 힙으로 만들기
            downHeap(a, i, n - 1)
        var i = n - 1
        while (i > 0) {
            swap(a, 0, i)//가장 큰 요소와 아직 정렬되지 않은 부분의 마지막 요소를 교환
            downHeap(a, 0, i - 1)//a[0]~a[i-1]을 힙으로 만듭니다.
            i--
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("힙 정렬")
        print("요솟수: ")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i] : ")
            x[i] = readLine()!!.toInt()
        }
        heapSort(x, nx)
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx)
            println("x[$i]=${x[i]}")
    }
}