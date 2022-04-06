package chap02

object ArrayEqual {
    private fun equals(a: IntArray, b: IntArray): Boolean {
        if (a.size != b.size)
            return false
        for (i in a.indices)
            if (a[i] != b[i])
                return false
        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("배열 a의 요솟수: ")
        val na = readLine()!!.toInt()
        val a = IntArray(na)
        for (i in 0 until na) {
            print("a[$i] : ")
            a[i] = readLine()!!.toInt()
        }
        print("배열 b의 요솟수: ")
        val nb = readLine()!!.toInt()
        val b = IntArray(nb)
        for (i in 0 until nb) {
            print("b[$i] : ")
            b[i] = readLine()!!.toInt()
        }
        println(
            "배열 a와 b는 ${
                if (equals(a, b)) "같습니다."
                else "같지 않습니다."
            }"
        )
    }
}