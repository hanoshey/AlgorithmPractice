package chap06

internal object Partition {
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    //배열을 나눕니다.
    fun partition(a: IntArray, n: Int) {
        var pl = 0//왼쪽 커서
        var pr = n - 1//오른쪽 커서
        val x = a[n / 2]//피벗(가운데위치의 값)
        do {
            while (a[pl] < x) pl++
            while (a[pr] > x) pr--
            if (pl <= pr)
                swap(a, pl++, pr--)
        } while (pl <= pr)
        println("피벗의 값은 ${x}입니다.")
        println("피벗 이하의 그룹")
        for (i in 0..pl - 1)
            print("${a[i]} ")
        println()
        if (pl > pr + 1) {
            println("피벗과 일치하는 그룹")
            for (i in pr + 1..pl - 1)
                print("${a[i]}")
            println()
        }
        println("피벗 이상의 그룹")
        for (i in pr + 1 until n)
            print("${a[i]} ")
        println()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("배열을 나눕니다.")
        print("요솟수 : ")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i] : ")
            x[i] = readLine()!!.toInt()
        }
        partition(x, nx)
    }
}