package chap05

internal object EuclidGCD {
    fun gcd(x: Int, y: Int): Int {
        return if (y == 0) x else gcd(y, x % y)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("두 정수의 최대공약수를 구합니다.")
        print("정수를 입력하세요. : ")
        val x = readLine()!!.toInt()
        print("정수를 입력하세요. : ")
        val y = readLine()!!.toInt()
        println("최대공약수는 ${gcd(x, y)}입니다.")
    }
}