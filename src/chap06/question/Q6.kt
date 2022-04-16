package chap06.question

internal object Q6 {
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    //단순 선택 정렬
    fun selectionSort(a: IntArray, n: Int) {
        val lengthofNum = IntArray(n)//각각의 자릿수를 저장하는 배열. swap 시 같이 변화하도록 한다.
        for (m in a.indices)         //이중 format을 이용하여 배열들이 정돈되게 출력되도록 한다.
            lengthofNum[m] = a[m].toString().length
        for (i in 0 until n - 1) {
            var min = i//아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스를 기록합니다.
            for (j in i + 1 until n)
                if (a[j] < a[min])
                    min = j
            for (k in a.indices) {
                if (k == i)
                    print("%%%ds".format(lengthofNum[k] + 1).format("*"))
                else if (k == min)
                    print("%%%ds".format(lengthofNum[k] + 1).format("+"))
                else
                    print("%%%ds".format(lengthofNum[k] + 1).format(" "))
            }
            println()
            for (l in a.indices) {
                print("%%%dd".format(lengthofNum[l] + 1).format(a[l]))
            }
            println()
            swap(a, i, min)//첫 요소와 가장 작은 요소를 교환합니다.
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("단순선택정렬(Q6)")
        print("요소수 : ")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i] : ")
            x[i] = readLine()!!.toInt()
        }
        selectionSort(x, nx)
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx)
            println("x[$i]=${x[i]}")
    }
}