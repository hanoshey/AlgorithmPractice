package chap01.question

object q9 {
    fun sumof(a: Int, b: Int): Int {
        var bigInt: Int
        var smallInt: Int
        if (a >= b) {
            bigInt = a
            smallInt = b
        } else {
            bigInt = b
            smallInt = a
        }
        var sum = 0
        while (bigInt >= smallInt) {
            sum += bigInt
            bigInt--
        }
        return sum
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("두 정수 사이의 합을 구하는 데에 쓰이는 값을 입력하시오.")
        print("첫번째 값 입력: ")
        val a= readLine()!!.toInt()
        print("두번째 값 입력: ")
        val b= readLine()!!.toInt()
        println(sumof(a,b))
    }
}