package chap05.question

internal object Q8 {
    var flag_a = BooleanArray(8) // 각 행에 퀸이 이미 배치되었는가?
    var flag_b = BooleanArray(15) // 대각선 ↙에 퀸이 이미 배치되었는가?
    var flag_c = BooleanArray(15) // 대각선 ↘에 퀸이 이미 배치되었는가?
    var pos = IntArray(8)

    fun print() {
        for (i in 0..7) {
            for (j in 0..7) {
                if (pos[j] == i)
                    print("■ ")
                else
                    print("□ ")
            }
            println()
        }
        println()
    }

    fun set(i: Int) {
        for (j in 0..7) {
            if (!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + 7]
            ) {        // 대각선 ↘에 아직 배치하지 않음
                pos[i] = j // 퀸을 j행에 배치함
                if (i == 7) // 모든 열에 배치함
                    print() else {
                    flag_c[i - j + 7] = true
                    flag_b[i + j] = flag_c[i - j + 7]
                    flag_a[j] = flag_b[i + j]
                    set(i + 1)
                    flag_c[i - j + 7] = false
                    flag_b[i + j] = flag_c[i - j + 7]
                    flag_a[j] = flag_b[i + j]
                }
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        set(0)
    }
}