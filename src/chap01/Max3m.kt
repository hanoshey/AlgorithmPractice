package chap01

fun max3(a: Int, b: Int, c: Int): Int {
    var max = a
    if (b > max) max = b
    if (c > max) max = c
    return max
}

fun main(args: Array<String>) {
    println("max(3,2,1) = " + max3(3, 2, 1))
    println("max(3,2,2) = " + max3(3, 2, 2))
    println("max(3,1,2) = " + max3(3, 1, 2))
    println("max(3,2,3) = " + max3(3, 2, 3))
    println("max(2,1,3) = " + max3(2, 1, 3))
    println("max(3,3,2) = " + max3(3, 3, 2))
    println("max(3,3,3) = " + max3(3, 3, 3))
    println("max(2,2,3) = " + max3(2, 2, 3))
    println("max(2,3,1) = " + max3(2, 3, 1))
    println("max(2,3,2) = " + max3(2, 3, 2))
    println("max(1,3,2) = " + max3(1, 3, 2))
    println("max(2,3,3) = " + max3(2, 3, 3))
    println("max(1,2,3) = " + max3(1, 2, 3))
}