package chap06

internal object SelectionSort {
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    //단순 선택 정렬
    fun selectionSort(a: IntArray, n: Int) {
        for (i in 0 until n - 1) {
            var min = i//아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스를 기록합니다.
            for (j in i + 1 until n)
                if (a[j] < a[min])
                    min = j
            swap(a, i, min)//첫 요소와 가장 작은 요소를 교환합니다.
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
        selectionSort(x, nx)
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx)
            println("x[$i]=${x[i]}")
    }
}