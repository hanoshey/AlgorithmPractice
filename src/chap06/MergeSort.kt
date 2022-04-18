package chap06

internal object MergeSort {
    var buff: IntArray? = null
    fun __mergeSort(a: IntArray, left: Int, right: Int) {
        if (left < right) {
            println("left:$left, right:$right")
            val center = (left + right) / 2
            var p = 0
            var j = 0
            var k = left
            __mergeSort(a, left, center)//앞부분 병합정렬
            __mergeSort(a, center + 1, right)//뒷부분 병합정렬
            var i = left
            while (i <= center)
                buff!![p++] = a[i++]
            buff!!.forEach { print("$it ") }
            println()
            print("p: $p\n")
            while (i <= right && j < p)
                a[k++] = if (buff!![j] <= a[i]) buff!![j++] else a[i++]
            while (j < p)
                a[k++] = buff!![j++]
        }
    }

    fun mergeSort(a: IntArray, n: Int) {
        buff = IntArray(n)//작업용 배열을 생성합니다
        __mergeSort(a, 0, n - 1)
        buff = null
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("병합 정렬")
        print("요솟수 : ")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i] : ")
            x[i] = readLine()!!.toInt()
        }
        mergeSort(x, nx)
        println("오름차순으로 정렬합니다.")
        for (i in 0 until nx)
            println("x[$i]= ${x[i]}")
    }
}