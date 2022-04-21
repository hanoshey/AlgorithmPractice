package chap09

import java.util.*

// 선형리스트 클래스 LinkedList<E>의 사용 예


object LinkedListTester {
    //--- 메뉴 선택 ---//
    fun SelectMenu(): Menu? {
        var key: Int
        do {
            for (m in Menu.values()) {
                System.out.printf("(%d) %s  ", m.ordinal, m.message)
                if (m.ordinal % 3 == 2 &&
                    m.ordinal != Menu.TERMINATE.ordinal
                ) println()
            }
            print(" : ")
            key = readLine()!!.toInt()
        } while (key < Menu.ADD_FIRST.ordinal ||
            key > Menu.TERMINATE.ordinal
        )
        return Menu.MenuAt(key)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var menu: Menu // 메뉴
        var data: Data // 추가용 데이터 참조
        var ptr: Data? // 검색용 데이터 참조
        val temp = Data() // 읽어 들일 데이터
        val list = LinkedList<Data>() // 리스트를 생성
        do {
            when (SelectMenu().also { menu = it!! }) {
                Menu.ADD_FIRST -> {
                    data = Data()
                    data.scanData("머리에 삽입", Data.NO or Data.NAME)
                    list.addFirst(data)
                }
                Menu.ADD_LAST -> {
                    data = Data()
                    data.scanData("꼬리에 삽입", Data.NO or Data.NAME)
                    list.addLast(data)
                }
                Menu.RMV_FIRST -> list.removeFirst()
                Menu.RMV_LAST -> list.removeLast()
                Menu.RMV_CRNT -> list.removeCurrentNode()
                Menu.SEARCH_NO -> {
                    temp.scanData("검색", Data.NO)
                    ptr = list.search(temp, Data.NO_ORDER)
                    if (ptr == null) println("그 번호의 데이터가 없습니다.") else println("검색 성공: $ptr")
                }
                Menu.SEARCH_NAME -> {
                    temp.scanData("검색", Data.NAME)
                    ptr = list.search(temp, Data.NAME_ORDER)
                    if (ptr == null) println("그 이름의 데이터가 없습니다.") else println("검색 성공: $ptr")
                }
                Menu.NEXT -> list.next()
                Menu.PRINT_CRNT -> list.printCurrentNode()
                Menu.DUMP -> list.dump()
                Menu.CLEAR -> list.clear()
                else -> {}
            }
        } while (menu != Menu.TERMINATE)
    }

    //--- 데이터(회원번호＋이름) ---//
    internal class Data {
        private var no // 회원번호
                : Int? = null
        private var name // 이름
                : String? = null

        //--- 문자열 표현을 반환 ---//
        override fun toString(): String {
            return "($no) $name"
        }

        //--- 데이터를 읽어 들임 ---//
        fun scanData(guide: String, sw: Int) {
            println(guide + "할 데이터를 입력하세요.")
            if (sw and NO == NO) {
                print("번호: ")
                no = readLine()!!.toInt()
            }
            if (sw and NAME == NAME) {
                print("이름: ")
                name = readLine()!!
            }
        }

        private class NoOrderComparator : Comparator<Data> {
            override fun compare(d1: Data, d2: Data): Int {
                return if (d1.no!! > d2.no!!) 1 else if (d1.no!! < d2.no!!) -1 else 0
            }
        }

        private class NameOrderComparator : Comparator<Data> {
            override fun compare(d1: Data, d2: Data): Int {
                return d1.name!!.compareTo(d2.name!!)
            }
        }

        companion object {
            const val NO = 1 // 번호를 읽어 들일까요?
            const val NAME = 2 // 이름을 읽어 들일까요?

            //--- 회원번호로 순서를 매기는 comparator  ---//
            val NO_ORDER: Comparator<Data> = NoOrderComparator()

            //--- 이름으로 순서를 매기는 comparator  ---//
            val NAME_ORDER: Comparator<Data> = NameOrderComparator()
        }
    }

    //--- 메뉴 열거형 ---//
    enum class Menu  // 생성자(constructor)
        (  // 표시할 문자열을 반환
        val message // 표시할 문자열
        : String
    ) {
        ADD_FIRST("머리 노드 삽입"), ADD_LAST("꼬리 노드 삽입"), RMV_FIRST("머리 노드 삭제"), RMV_LAST("꼬리 노드 삭제"), RMV_CRNT("선택 노드 삭제"), CLEAR(
            "전체 노드 삭제"
        ),
        SEARCH_NO("번호 검색"), SEARCH_NAME("이름 검색"), NEXT("선택 노드를 하나 뒤쪽으로 진행"), PRINT_CRNT("선택 노드 표시"), DUMP("전체 노드 표시"), TERMINATE(
            "종료"
        );

        companion object {
            fun MenuAt(idx: Int): Menu? {                // 순서가 idx번째인 열거를 반환
                for (m in values()) if (m.ordinal == idx) return m
                return null
            }
        }
    }
}
