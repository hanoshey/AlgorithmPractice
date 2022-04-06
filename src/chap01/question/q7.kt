package chap01.question

object q7 {
    @JvmStatic
    fun main(args: Array<String>){
        println("1부터 n까지의 합을 구합니다.")
        println("n의 값: ")
        val n = readLine()!!.toInt()
        var sum = 0
        var i = 1
        while (i <= n) {
            sum += i
            print("$i ")
            i++
            if(i<=n)
                print("+ ")
            else
                print("= ")
        }
        println("$sum")
    }
}