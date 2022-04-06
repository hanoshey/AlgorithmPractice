package chap02.question

object Q2 {
    private fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
        println("a[$idx1]과(와) a[$idx2]를 교환합니다.")
    }

    private fun reverse(a: IntArray) {
        for (i in 0 until a.size / 2) {
            for (j in a)
                print("$j ")
            println()
            swap(a, i, a.size - i - 1)
        }
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
        for (i in x)
            print("$i ")
        println("\n역순 정렬을 마쳤습니다.")
    }
}