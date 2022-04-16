package chap06

internal object InsertionSort {
    //단순 삽입 정렬
    fun insertionSort(a: IntArray, n: Int) {
        for (i in 1 until n) {
            val tmp = a[i]
            var j = i
            while (j > 0 && a[j - 1] > tmp) {
                a[j] = a[j - 1]
                j--
            }
            a[j] = tmp
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("단순 삽입 정렬")
        print("요솟수 : ")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i] : ")
            x[i] = readLine()!!.toInt()
        }
        insertionSort(x, nx)
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx)
            println("x[$i]=${x[i]}")
    }
}