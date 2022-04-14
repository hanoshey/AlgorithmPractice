package chap05
internal object RecurX1{
    fun recur(n: Int) {
        var n = n
        while (n > 0) {
            recur(n - 1)
            println(n)
            n -= 2
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("정수를 입력하세요. : ")
        val x= readLine()!!.toInt()
        recur(x)
    }
}