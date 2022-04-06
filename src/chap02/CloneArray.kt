package chap02;

object CloneArray {
    @JvmStatic
    fun main(args: Array<String>) {
        val a = intArrayOf(1, 2, 3, 4, 5)
        val b = a.clone()
        b[3] = 0
        print("a = ")
        for (i in a.indices)
            print(" ${a[i]}")
        print("\nb = ")
        for (i in b.indices)
            print(" ${b[i]}")
    }
}