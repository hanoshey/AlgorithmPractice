package chap01.question

fun min3(a: Int, b: Int, c: Int): Int {
    var min = a
    if (b < min) min = b
    if (c < min) min = c
    return min
}

fun main() {
    println(min3(9, 77, 2))
}
