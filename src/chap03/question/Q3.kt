package chap03.question

internal object Q3 {
    private fun searchIdx(a: IntArray, n: Int, key: Int, idx: IntArray): Int {
        var howMany = 0
        for (i in 0 until n) {
            if (a[i] == key) {
                idx[howMany++] = i
            }
        }
        return howMany
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print("요솟수 : ")
        val num = readLine()!!.toInt()
        val x = IntArray(num)
        val y = IntArray(num)
        for (i in 0 until num) {
            print("x[$i] : ")
            x[i] = readLine()!!.toInt()
        }
        print("검색할 값 : ")
        val ky = readLine()!!.toInt()
        val idx = searchIdx(x, num, ky, y) //배열 x에서 키 값이 ky인 요소 검색
        if (idx == 0) println("그 값의 요소가 없습니다.") else {
            print("배열 idx의 요소는 {")
            for(i in 0 until idx){
                print("${y[i]} ")
            }
            print("}입니다.")
        }
        println("반환값은 ${idx}입니다...")
    }
}