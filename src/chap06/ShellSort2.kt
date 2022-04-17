package chap06

internal object ShellSort2 {
    fun shellSort(a: IntArray, n: Int) {
        var h = 1
        while (h < n / 9) {
            h = h * 3 + 1
        }
        while (h > 0) {
            for (i in h until n) {
                val tmp = a[i]
                var j = i - h
                while (j >= 0 && a[j] > tmp) {
                    a[j + h] = a[j]
                    j -= h
                }
                a[j + h] = tmp
                println("h: $h, i: $i, j:$j, h+j:${h + j}")
            }
            h /= 3
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("쉘 정렬(버전2)")
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