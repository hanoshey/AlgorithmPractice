package chap06

internal object ShellSort {
    fun shellSort(a: IntArray, n: Int) {
        var h = n / 2
        while (h > 0) {
            for (i in h until n) {
                val tmp = a[i]
                var j = i - h
                while (j >= 0 && a[j] > tmp) {
                    a[j + h] = a[j]
                    j -= h
                }
                a[j + h] = tmp
            }
            h /= 2
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("쉘 정렬(버전1)")
        print("요솟수 : ")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i] : ")
            x[i] = readLine()!!.toInt()
        }
        shellSort(x, nx)
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx)
            println("x[$i]=${x[i]}")
    }
}