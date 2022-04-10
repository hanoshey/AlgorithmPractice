package chap03

import java.util.*
import kotlin.jvm.JvmStatic

internal object StringBinarySearch {
    @JvmStatic
    fun main(args: Array<String>) {
        val x = arrayOf( // 자바에서 사용하는 키워드(알파벳 순)
            "abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else",
            "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import",
            "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super",
            "switch", "synchronized", "this", "throw", "throws",
            "transient", "try", "void", "volatile", "while"
        )
        print("원하는 키워드를 입력하세요.: ") // 키값을 읽어 들임
        val ky = readLine()!!.toString()
        val idx = Arrays.binarySearch(x, ky) // 배열 x에서 값이 ky인 요소를 검색
        if (idx < 0) println("해당 키워드가 없습니다.") else println("해당 키워드는 x[$idx]에 있습니다.")
    }
}