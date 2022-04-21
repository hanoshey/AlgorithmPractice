package chap11

import java.lang.OutOfMemoryError
import chap11.ChainHashTester
import kotlin.jvm.JvmStatic
import chap11.OpenHashTester
import java.util.*

// 오픈 주소법에 의한 해시의 사용 예
object OpenHashTester {
    var stdIn = Scanner(System.`in`)

    //--- 메뉴 선택 ---//
    fun SelectMenu(): Menu? {
        var key: Int
        do {
            for (m in Menu.values()) System.out.printf("(%d) %s  ", m.ordinal, m.message)
            print(" : ")
            key = stdIn.nextInt()
        } while (key < Menu.ADD.ordinal || key > Menu.TERMINATE.ordinal)
        return Menu.MenuAt(key)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var menu: Menu // 메뉴 
        var data: Data // 추가용 데이터 참조
        val temp = Data() // 읽어 들일 데이터
        val hash = OpenHash<Int, Data>(13)
        do {
            when (SelectMenu().also { menu = it!! }) {
                Menu.ADD -> {
                    data = Data()
                    data.scanData("추가", Data.NO or Data.NAME)
                    val k = hash.add(data.keyCode()!!, data)
                    when (k) {
                        1 -> println("그 키값은 이미 등록되어 있습니다.")
                        2 -> println("해시 테이블이 가득 찼습니다.")
                    }
                }
                Menu.REMOVE -> {
                    temp.scanData("삭제", Data.NO)
                    hash.remove(temp.keyCode()!!)
                }
                Menu.SEARCH -> {
                    temp.scanData("검색", Data.NO)
                    val t = hash.search(temp.keyCode()!!)
                    if (t != null) println("그 키를 갖는 데이터는 " + t + "입니다.") else println("해당 데이터가 없습니다.")
                }
                Menu.DUMP -> hash.dump()
            }
        } while (menu != Menu.TERMINATE)
    }

    //--- 데이터(회원번호＋이름) ---//
    internal class Data {
        private var no // 회원번호(키값)
                : Int? = null
        private var name // 이름
                : String? = null

        //--- 키값 ---//
        fun keyCode(): Int? {
            return no
        }

        //--- 문자열 표현을 반환 ---//
        override fun toString(): String {
            return name!!
        }

        //--- 데이터를 읽어 들임 ---//
        fun scanData(guide: String, sw: Int) {
            println(guide + "할 데이터를 입력하세요.")
            if (sw and NO == NO) {
                print("번호: ")
                no = stdIn.nextInt()
            }
            if (sw and NAME == NAME) {
                print("이름: ")
                name = stdIn.next()
            }
        }

        companion object {
            const val NO = 1 // 번호를 읽어 들일까요?
            const val NAME = 2 // 이름을 읽어 들일까요?
        }
    }

    //--- 메뉴 열거형 ---//
    enum class Menu  // 생성자(constructor)
        (  // 표시할 문자열을 반환
        val message // 표시할 문자열
        : String
    ) {
        ADD("추가"), REMOVE("삭제"), SEARCH("검색"), DUMP("표시"), TERMINATE("종료");

        companion object {
            fun MenuAt(idx: Int): Menu? {        // 순서가 idx번째인 열거를 반환
                for (m in values()) if (m.ordinal == idx) return m
                return null
            }
        }
    }
}