package chap01

object q16 {
    fun spira(n: Int) {
        for (i in 0 until n) {
            for (k in 0 until n-i)
                print(" ")
            for (j in 0 until (i) * 2 + 1)
                print("*")
            println()
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("출력하고자 하는 피라미드의 단 수를 입력하세요.")
        spira(readLine()!!.toInt())
    }
}