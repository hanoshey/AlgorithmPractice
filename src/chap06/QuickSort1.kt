package chap06

internal object QuickSort1 {
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1];a[idx1] = a[idx2];a[idx2] = t
    }

    fun quickSort(a: IntArray, left: Int, right: Int) {
        var pl = left
        var pr = right
        val x = a[(pl + pr) / 2]
        print("a[%d]~a[%d] : {".format(left, right))
        for (i in left until right)
            print("%d, ".format(a[i]))
        print("%d}\n".format(a[right]))
        do {
            while (a[pl] < x) pl++
            while (a[pr] > x) pr--
            if (pl <= pr)
                swap(a, pl++, pr--)
        } while (pl <= pr)
        if (left < pr) quickSort(a, left, pr)
        if (pl < right) quickSort(a, pl, right)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("퀵 정렬")
        print("요솟수 :")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i] :")
            x[i] = readLine()!!.toInt()
        }
        quickSort(x, 0, nx - 1)
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx)
            println("x[$i]= ${x[i]}")
    }
}