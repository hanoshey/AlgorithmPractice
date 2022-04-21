package chap10

import java.util.*
import kotlin.jvm.JvmStatic

// 이진검색트리클래스BinTree<K,V>의 사용 예
internal object BinTreeTester {
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
        var ptr: Data // 검색용 데이터 참조
        val temp = Data() // 입력용 데이터
        val tree = BinTree<Int, Data>()
        do {
            when (SelectMenu().also { menu = it!! }) {
                Menu.ADD -> {
                    data = Data()
                    data.scanData("삽입", Data.NO or Data.NAME)
                    tree.add(data.keyCode()!!, data)
                }
                Menu.REMOVE -> {
                    temp.scanData("삭제", Data.NO)
                    tree.remove(temp.keyCode()!!)
                }
                Menu.SEARCH -> {
                    temp.scanData("검색", Data.NO)
                    ptr = tree.search(temp.keyCode()!!)!!
                    if (ptr != null) println("그 번호의 이름은 " + ptr + "입니다.") else println("해당 데이터가 없습니다.")
                }
                Menu.PRINT -> tree.print()
            }
        } while (menu != Menu.TERMINATE)
    }

    //--- 데이터(회원 번호＋이름) ---//
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
                print("번호  ")
                no = stdIn.nextInt()
            }
            if (sw and NAME == NAME) {
                print("이름  ")
                name = stdIn.next()
            }
        }

        companion object {
            const val NO = 1 // 번호를 읽어 들일까요?
            const val NAME = 2 // 이름을 읽어 들일까요?
        }
    }

    //--- 메뉴 열거형 ---//
    internal enum class Menu  // 생성자(constructor)
        (  // 표시할 문자열을 반환
        val message // 표시할 문자열
        : String
    ) {
        ADD("삽입"), REMOVE("삭제"), SEARCH("검색"), PRINT("표시"), TERMINATE("종료");

        companion object {
            fun MenuAt(idx: Int): Menu? {        // 순서가 idx번째인 열거를 반환
                for (m in values()) if (m.ordinal == idx) return m
                return null
            }
        }
    }
}