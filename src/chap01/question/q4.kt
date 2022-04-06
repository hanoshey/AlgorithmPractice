package chap01.question

object q4 {
    private fun med3(a: Int, b: Int, c: Int): Int {
        return if (a >= b) if (b >= c) b else if (a <= c) a else c else if (a > c) a else if (b > c) c else b
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("med(3,2,1) = " + med3(3, 2, 1))
        println("med(3,2,2) = " + med3(3, 2, 2))
        println("med(3,1,2) = " + med3(3, 1, 2))
        println("med(3,2,3) = " + med3(3, 2, 3))
        println("med(2,1,3) = " + med3(2, 1, 3))
        println("med(3,3,2) = " + med3(3, 3, 2))
        println("med(3,3,3) = " + med3(3, 3, 3))
        println("med(2,2,3) = " + med3(2, 2, 3))
        println("med(2,3,1) = " + med3(2, 3, 1))
        println("med(2,3,2) = " + med3(2, 3, 2))
        println("med(1,3,2) = " + med3(1, 3, 2))
        println("med(2,3,3) = " + med3(2, 3, 3))
        println("med(1,2,3) = " + med3(1, 2, 3))
    }
}