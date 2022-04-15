package chap06

internal object Q3 {
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    //버블 정렬
    fun bubbleSort(a: IntArray, n: Int) {
        var compareCount = 0
        var exchangeCount = 0
        var lengthofAry = IntArray(n)//각각의 자릿수를 저장하는 배열. swap 시 같이 변화하도록 한다.
        for (m in a.indices)         //이중 format을 이용하여 배열들이 정돈되게 출력되도록 한다.
            lengthofAry[m] = a[m].toString().length
        for (i in 0 until n - 1) {
            println("패스$i:")
            var j = n - 1
            while (j > i) {
                compareCount++
                if (a[j - 1] > a[j]) {
                    exchangeCount++
                    for (k in a.indices) {
                        if (k == j)//자릿수 하나는 부호가 차지하므로 값을 유지시킨다.
                            print("+%%%dd".format(lengthofAry[k]).format(a[k]))
                        else
                            print("%%%dd".format(lengthofAry[k] + 1).format(a[k]))//한 칸을 띄운다.
                    }
                    println()
                    swap(a, j - 1, j)
                    swap(lengthofAry, j - 1, j)//자릿수 배열도 하나를 빼 준다.
                } else {
                    for (k in a.indices) {
                        if (k == j)
                            print("-%%%dd".format(lengthofAry[k]).format(a[k]))
                        else
                            print("%%%dd".format(lengthofAry[k] + 1).format(a[k]))
                    }
                    println()
                }
                j--
            }
            for (k in a.indices) {
                print("%%%dd".format(lengthofAry[k] + 1).format(a[k]))
            }
            println()
            if (exchangeCount == 0) break
        }
        println("비교를 ${compareCount}회 했습니다.")
        println("교환을 ${exchangeCount}회 했습니다.")
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("버블정렬(버전1)")
        print("요소수 : ")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i] : ")
            x[i] = readLine()!!.toInt()
        }
        bubbleSort(x, nx)
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx)
            println("x[$i]=${x[i]}")

    }
}