package chap01.question

fun max4(a: Int, b: Int, c: Int, d: Int): Int {
    var max = a
    if (b > max) max = b
    if (c > max) max = c
    if (d > max) max = d
    return max
}

fun main(args: Array<String>) {
    println(max4(9, 77, 2, 64))
}
