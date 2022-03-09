package chap01

object q5 {
    private fun med3(a: Int, b: Int, c: Int): Int {
        if ((a in c..b) || (a in b..c))
            return a
        else if ((b in (c + 1) until a) || (b in (a + 1) until c))
            return b
        return c
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(med3(35, 758, 65))
    }
}