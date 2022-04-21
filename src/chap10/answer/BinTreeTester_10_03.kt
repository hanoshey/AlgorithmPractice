package chap10.answer

import chap10.BinTree
import java.util.*
import kotlin.jvm.JvmStatic

// 이진검색트리 클래스 BinTree<K,V>의 사용 예 (comparator를 사용)
internal object BinTreeTester_10_03 {
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
        var ptr: Data? // 검색용 데이터 참조
        val temp = Data() // 입력 받기용 데이터

        class IntegerDecComparator : Comparator<Int> {
            override fun compare(n1: Int, n2: Int): Int {
                return if (n1 > n2) 1 else if (n1 < n2) -1 else 0
            }
        }

        // 정수의 내림차순으로 순서매기기를 수행하는 comparator
        val INT_DEC_COMP = IntegerDecComparator()
        val tree = BinTree<Int, Data>(INT_DEC_COMP)

        //BinTree<Integer, Data> tree = new BinTree<Integer, Data>();
        do {
            when (SelectMenu().also { menu = it!! }) {
                Menu.ADD -> {
                    data = Data()
                    data.scanData("삽입 ", Data.NO or Data.NAME)
                    tree.add(data.keyCode()!!, data)
                }
                Menu.REMOVE -> {
                    temp.scanData("삭제", Data.NO)
                    tree.remove(temp.keyCode()!!)
                }
                Menu.SEARCH -> {
                    temp.scanData("검색", Data.NO)
                    ptr = tree.search(temp.keyCode()!!)
                    if (ptr != null) println("그 번호의 이름은 " + ptr + "입니다.") else println("해당 데이터가 없습니다.")
                }
                Menu.PRINT -> tree.print()
            }
        } while (menu != Menu.TERMINATE)
    }

    // 데이터(회원번호+이름)
    internal class Data {
        private var no // 회원번호 (키 값)
                : Int? = null
        private var name // 이름
                : String? = null

        // 키 값
        fun keyCode(): Int? {
            return no
        }

        // 문자열을 반환합니다.
        override fun toString(): String {
            return name!!
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
        (  // 출력용 문자열 반환
        val message // 표시용 문자열
        : String
    ) {
        ADD("삽입 "), REMOVE("삭제"), SEARCH("검색"), PRINT("출력"), TERMINATE("종료");

        companion object {
            fun MenuAt(idx: Int): Menu? { // 서수가 idx인 열거를 반환
                for (m in values()) if (m.ordinal == idx) return m
                return null
            }
        }
    }
}