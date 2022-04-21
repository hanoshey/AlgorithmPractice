package chap11.answer

import chap11.ChainHash
import java.lang.OutOfMemoryError
import chap11.answer.ChainHashTester_11_01
import kotlin.jvm.JvmStatic
import chap11.answer.OpenHashTester_11_01
import java.util.*

// 체인법에 의한 해시의 사용 예 (키는 이름)
internal object ChainHashTester_11_01 {
    var stdIn = Scanner(System.`in`)

    // 메뉴선택
    fun SelectMenu(): Menu? {
        var key: Int
        do {
            for (m in Menu.values()) {
                System.out.printf("(%d) %s  ", m.ordinal, m.message)
                if (m.ordinal % 3 == 2 && m.ordinal != Menu.TERMINATE.ordinal) println()
            }
            print("：")
            key = stdIn.nextInt()
        } while (key < Menu.ADD.ordinal || key > Menu.TERMINATE.ordinal)
        return Menu.MenuAt(key)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var menu: Menu // 메뉴
        var data: Data // 추가용 데이터 참조
        val temp = Data() // 입력 받기용 데이터
        val hash = ChainHash<String?, Data>(13)
        do {
            when (SelectMenu().also { menu = it!! }) {
                Menu.ADD -> {
                    data = Data() // 추가
                    data.scanData("추가", Data.NO or Data.NAME)
                    val k = hash.add(data.keyCode(), data)
                    when (k) {
                        1 -> println("그 키값은 이미 등록되어 있습니다.")
                        2 -> println("해시 테이블이 가득 찼습니다.")
                    }
                }
                Menu.REMOVE -> {
                    temp.scanData("삭제", Data.NAME)
                    hash.remove(temp.keyCode())
                }
                Menu.SEARCH -> {
                    temp.scanData("검색", Data.NAME)
                    val t = hash.search(temp.keyCode())
                    if (t != null) println("그 키를 갖는 데이터는 " + t + "입니다.") else println("해당 하는 데이터가 없습니다.")
                }
                Menu.DUMP -> hash.dump()
            }
        } while (menu != Menu.TERMINATE)
    }

    // 데이터(회원번호+이름)
    internal class Data {
        private var no // 회원번호 (키값)
                : Int? = null
        private var name // 이름
                : String? = null

        // 키값
        fun keyCode(): String? {
            return name
        }

        // 문자열을 반환합니다.
        override fun toString(): String {
            return Integer.toString(no!!)
        }

        // 데이터를 입력 받음
        fun scanData(guide: String, sw: Int) {
            println(guide + "하는 데이터를 입력하세요.")
            if (sw and NO == NO) {
                print("번호：")
                no = stdIn.nextInt()
            }
            if (sw and NAME == NAME) {
                print("이름：")
                name = stdIn.next()
            }
        }

        companion object {
            const val NO = 1 // 번호를 입력 받습니까?
            const val NAME = 2 // 이름을 입력 받습니까?
        }
    }

    // 메뉴열거형
    internal enum class Menu  // 생성자
        (  // 표시용 문자열을 반환
        val message // 표시용 문자열
        : String
    ) {
        ADD("데이터 추가"), REMOVE("데이터 삭제"), SEARCH("데이터 검색"), DUMP("모든  데이터 출력"), TERMINATE("종료");

        companion object {
            fun MenuAt(idx: Int): Menu? { // 서수가 idx임. 열거를 반환
                for (m in values()) if (m.ordinal == idx) return m
                return null
            }
        }
    }
}