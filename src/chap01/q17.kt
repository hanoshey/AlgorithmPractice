package chap01

object q17{
    fun npira(n:Int){
        for (i in 0 until n) {
            for (k in 0 until n-i)
                print(" ")
            for (j in 0 until(i) * 2 + 1)
                print("${(i%10)+1}")
            println()
        }
    }
    @JvmStatic
    fun main(args: Array<String>) {
        print("출력하고자 하는 숫자 피라미드의 단 수를 입력하세요.")
        npira(readLine()!!.toInt())
    }
}