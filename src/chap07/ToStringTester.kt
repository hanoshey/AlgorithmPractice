package chap07

class A {}//toString을 정의하지 않습니다.
class B(val x: Int = 0) {
    override fun toString(): String {
        return "B[$x]"
    }

}

internal object ToStringTester {
    @JvmStatic
    fun main(args: Array<String>) {
        val a1 = A()
        val a2 = A()
        val b1 = B(18)
        val b2 = B(55)
        println("a1=${a1}")
        println("a2=${a2}")
        println("b1=${b1}")
        println("b2=${b2}")
    }
}