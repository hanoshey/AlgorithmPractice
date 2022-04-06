package chap02

object ReverseArray {
    private fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    private fun reverse(a: IntArray) {
        for (i in 0 until a.size / 2)
            swap(a, i, a.size - i - 1)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("요솟수: ")
        val num = readLine()!!.toInt()
        val x = IntArray(num)
        for (i in 0 until num) {
            print("x[$i] : ")
            x[i] = readLine()!!.toInt()
        }
        reverse(x)
        println("요소를 역순으로 정렬했습니다.")
        for (i in 0 until num)
            println("x[$i] = ${x[i]}")
    }
}