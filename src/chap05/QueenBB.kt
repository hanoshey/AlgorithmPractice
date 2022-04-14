package chap05

internal object QueenBB {
    val flag = BooleanArray(8)//각 행에 퀸을 배치했는지 체크
    val pos = IntArray(8)//각 열의 퀸의 위치
    fun print() {
        for (i in 0 until 8)
            print("%2d".format(pos[i]))
        println()
    }

    fun set(i: Int) {
        for (j in 0 until 8) {
            if (!flag[j]) {//j행에는 퀸을 아직 배치하지 않았다면
                pos[i] = j//퀸을 j행에 배치합니다.
                if (i == 7)
                    print()
                else {
                    flag[j] = true
                    set(i + 1)
                    flag[j] = false
                }
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        set(0)
    }
}