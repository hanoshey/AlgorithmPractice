package chap06.question

internal object Q5 {
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    //버블 정렬
    fun bubbleSort(a: IntArray, n: Int) {
        var k = 0//a[k]보다 앞쪽은 정렬을 마친 상태
        var p = n - 1//a[p]보다 뒤쪽은 정렬을 마친 상태
        var pass = 1
        while (k < p) {
            if (pass % 2 == 1) {
                var last = n - 1//마지막으로 요소를 교환한 위치
                var j = n - 1
                while (j > k) {
                    if (a[j - 1] > a[j]) {
                        swap(a, j - 1, j)
                        last = j
                    }
                    j--
                }
                k = last
                pass++
            } else {
                var first = 0
                var j = 0
                while (j < p) {
                    if (a[j + 1] < a[j]) {
                        swap(a, j, j + 1)
                        first = j
                    }
                    j++
                }
                p = first
                pass++
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("버블정렬(Q5)")
        print("요소수 : ")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i] : ")
            x[i] = readLine()!!.toInt()
        }
        bubbleSort(x, nx)
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx)
            println("x[$i]=${x[i]}")
    }
}