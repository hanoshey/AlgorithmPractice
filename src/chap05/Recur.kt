package chap05
internal object Recur{
    fun recur(n:Int){
        if(n>0){
            recur(n-1)
            println(n)
            recur(n-2)
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("정수를 입력하세요. : ")
        val x= readLine()!!.toInt()
        recur(x)
    }
}