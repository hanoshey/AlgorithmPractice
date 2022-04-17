package chap06

internal object MergeArray {
    fun merge(a: IntArray, na: Int, b: IntArray, nb: Int, c: IntArray) {
        var pa = 0
        var pb = 0
        var pc = 0
        while (pa < na && pb < nb)//작은 값을 저장합니다.
            c[pc++] = if (a[pa] < b[pb]) a[pa++] else b[pb++]
        while (pa < na)//a에 남아 있는 요소를 복사합니다.
            c[pc++] = a[pa++]
        while (pb < nb)//b에 남아 있는 요소를 복사합니다.
            c[pc++] = b[pb++]
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val a = intArrayOf(2, 4, 6, 8, 11, 13)
        val b = intArrayOf(1, 2, 3, 4, 9, 16, 21)
        val c = IntArray(13)
        println("두 배열의 병합")
        merge(a, a.size, b, b.size, c)//병합하여 c에 저장
        println("배열 a와 b를 병합하여 c에 저장했습니다.")
        println("배열 a : ")
        for (i in a.indices)
            println("a[$i]=${a[i]}")
        println("배열 b : ")
        for (i in b.indices)
            println("b[$i]=${b[i]}")
        println("배열 c : ")
        for (i in c.indices)
            println("c[$i]=${c[i]}")

    }
}