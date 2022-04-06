package chap02.question

object Q4{
    private fun copy(a: IntArray, b:IntArray) {
        if (a.size != b.size)
            println("배열의 크기가 달라 복사가 불가능합니다.")
        else
            for(i in b.indices)
                a[i]=b[i]
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("배열 a의 요솟수: ")
        val na = readLine()!!.toInt()
        val a = IntArray(na)
        print("배열 b의 요솟수: ")
        val nb = readLine()!!.toInt()
        val b = IntArray(nb)
        for (i in 0 until nb) {
            print("b[$i] : ")
            b[i] = readLine()!!.toInt()
        }
        copy(a,b)
        for (i in a.indices) {
            print("a[$i] : ${a[i]}\n")
        }
    }
}