package chap01

object q12 {
    @JvmStatic
    fun main(args: Array<String>) {
        print("   |")
        for(i in 1..9)
            print("%3d".format(i))
        println("\n---+---------------------")
        for (i in 1..9) {
            print("%2d | ".format(i))
            for (j in 1..9)
                print("%3d".format(i * j))
            println()
        }
    }
}