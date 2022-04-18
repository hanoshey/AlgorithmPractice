package chap06

internal object Fsort {
    fun fSort(a: IntArray, n: Int, max: Int) {
        val f = IntArray(max + 1)//누적 도수
        val b = IntArray(n)//작업용 목적 배열
        for (i in 0 until n) f[a[i]]++//1단계
        for (i in 1..max) f[i] += f[i - 1]//2단계
        for (i in n - 1 downTo 0) b[--f[a[i]]] = a[i]//3단계
        for (i in 0 until n) a[i] = b[i]//4단계
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("도수 정렬")
        print("요솟수 : ")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            do {
                print("x[$i] : ")
                x[i] = readLine()!!.toInt()
            } while (x[i] < 0)
        }
        var max = x[0]
        for (i in 1 until nx)
            if (x[i] > max) max = x[i]
        fSort(x, nx, max)//배열 x를 도수 정렬
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx)
            println("x[$i]=${x[i]}")
    }
}