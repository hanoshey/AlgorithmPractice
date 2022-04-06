package chap02.question

object Q3{
    private fun sumOf(a:IntArray):Int{
        var sum=0
        for(i in a)
            sum+=i
        return sum
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
        println("배열의 모든 요소의 합계는 ${sumOf(x)}입니다.")
    }
}