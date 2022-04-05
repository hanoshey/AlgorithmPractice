package chap01

object q8 {
    @JvmStatic
    fun main(args: Array<String>){
        println("1부터 n까지의 합을 구합니다.")
        println("n의 값: ")
        val n = readLine()!!.toFloat()
        var sum = 0
        sum=((1+n)*(n/2)).toInt()
        println("1부터 ${n.toInt()} 까지의 합은 $sum 입니다.")
    }
}