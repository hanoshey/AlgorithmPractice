package chap03

import kotlin.jvm.JvmStatic
import chap03.GenericClassTester.GenericClass

internal object GenericClassTester {
    @JvmStatic
    fun main(args: Array<String>) {
        val s = GenericClass("ABC")
        val n = GenericClass(15)
        println(s.xyz)
        println(n.xyz)
    }

    internal class GenericClass<T>(val xyz: T)
}