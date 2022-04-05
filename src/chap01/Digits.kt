package chap01

import java.util.*
import kotlin.jvm.JvmStatic

//두자리의 양수를 입력합니다.
internal object Digits {
    @JvmStatic
    fun main(args: Array<String>) {
        val stdIn = Scanner(System.`in`)
        var no: Int
        println("2자리의 정수를 입력하세요.")
        do {
            print("입력: ")
            no = stdIn.nextInt()
        } while (no < 10 || no > 99)
        println("변수 no의 값은 " + no + "가(이) 되었습니다.")
    }
}