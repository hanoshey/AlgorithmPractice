package chap05.question

internal object Q1 {
    private fun factorial(n: Int): Int {
        return if(n==1) 1
        else {
            var result=1
            for (i in 2..n) {
                result *= i
            }
            result
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("정수를 입력하세요. : ")
        val x = readLine()!!.toInt()
        println(x.toString() + "의 팩토리얼은 " + factorial(x) + "입니다.")
    }
}