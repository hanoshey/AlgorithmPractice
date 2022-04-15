package chap06

internal object BubbleSort {
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    //버블 정렬
    fun bubbleSort(a: IntArray, n: Int) {
        for (i in 0 until n - 1) {
            var j = n - 1
            while (j > i) {
                if (a[j - 1] > a[j])
                    swap(a, j - 1, j)
                j--
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("버블정렬(버전1)")
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