package chap01

object q14{
    @JvmStatic
    fun main(args:Array<String>){
        println("사각형을 출력합니다.")
        print("단 수 : ")
        val n= readLine()!!.toInt()
        for (i in 1..n) {
            for (j in 1..n)
                print("*")
            println()
        }
    }
}