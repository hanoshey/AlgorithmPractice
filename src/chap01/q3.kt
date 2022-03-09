package chap01

fun min4(a: Int, b: Int, c: Int,d:Int): Int {
    var min = a
    if (b < min) min = b
    if (c < min) min = c
    if (d < min) min = d
    return min
}
fun main() {
    println(min4(9, 77, 2000,6524))
}
