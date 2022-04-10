package chap03.question

internal object Q4 {
    private fun binSearchEx(a: IntArray, n: Int, key: Int): Int {
        var pl = 0
        var pr = n - 1
        print("  |")
        for (j in 0 until n)
            print("$j  ")
        println()
        print("--+")
        print("-".repeat(n * 3))
        println()
        do {
            val pc = (pl + pr) / 2 //중앙 요소 인덱스
            println("  |" + "   ".repeat(pl) + "<- " + "   ".repeat(pc-pl-1) + "+ " + "   ".repeat(pr-pc-pl-1)+"->")
            print("$pc |")
            for (k in a)
                print("$k  ")
            println()
            if (a[pc] == key) return pc else if (a[pc] < key) pl = pc + 1 else pr = pc - 1
        } while (pl <= pr)
        return -1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("요솟수 : ")
        val num = readLine()!!.toInt()
        val x = IntArray(num) //요솟수가 num인 배열
        println("오름차순으로 입력하세요")
        print("x[0] : ")
        x[0] = readLine()!!.toInt()
        for (i in 1 until num) {
            do {
                print("x[$i] : ")
                x[i] = readLine()!!.toInt()
            } while (x[i] < x[i - 1]) //바로 앞의 요소보다 작으면 다시 입력
        }
        print("검색할 값 : ")
        val ky = readLine()!!.toInt()
        val idx = binSearchEx(x, num, ky)
        if (idx == -1) println("그 값의 요소가 없습니다.") else println("${ky}은(는) x[$idx]에 있습니다.")
    }
}