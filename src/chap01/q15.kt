package chap01

object q15 {
    @JvmStatic
    fun triangleLB(n:Int) {
        println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.")
        for (i in 1..n) {
            for (j in 1..i)
                print("*")
            println()
        }
    }
    fun triangleLU(n:Int) {
        println("왼쪽 위가 직각인 이등변 삼각형을 출력합니다.")
        for (i in 1..n) {
            for(k in 1..n-i+1)
                print("*")
            println()
        }
    }
    fun triangleRU(n:Int) {
        println("오른쪽 위가 직각인 이등변 삼각형을 출력합니다.")
        for (i in 1..n) {
            for (j in 1..i)
                print(" ")
            for (k in 1..n-i+1)
                print("*")
            println()
        }
    }
    fun triangleRB(n:Int) {
        println("오른쪽 아래가 직각인 이등변 삼각형을 출력합니다.")
        for (i in 1..n) {
            for(k in 1..n-i)
                print(" ")
            for (j in 1..i)
                print("*")
            println()
        }
    }
    @JvmStatic
    fun main(args:Array<String>){
        print("출력하고자 하는 이등변삼각형의 변의 길이를 입력하세요 : ")
        val n= readLine()!!.toInt()
        triangleLB(n)
        triangleLU(n)
        triangleRU(n)
        triangleRB(n)
    }
}