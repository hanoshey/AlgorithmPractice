package chap06

import chap04.IntStack

internal object QuickSort2 {
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1];a[idx1] = a[idx2];a[idx2] = t
    }

    fun quickSort(a: IntArray, left: Int, right: Int) {
        var left = left
        var right = right
        val lstack = IntStack(right - left + 1)
        val rstack = IntStack(right - left + 1)
        lstack.push(left)
        rstack.push(right)
        while (lstack.isEmpty != true) {
            left = lstack.pop()
            var pl = left
            right = rstack.pop()
            var pr = right
            val x = a[(left + right) / 2]
            do {
                while (a[pl] < x) pl++
                while (a[pr] > x) pr--
                if (pl <= pr)
                    swap(a, pl++, pr--)
            } while (pl <= pr)
            if (left < pr) {
                lstack.push(left)//왼쪽 그룹 범위의
                rstack.push(pr)//인덱스를 푸시합니다
            }
            if (pl < right) {
                lstack.push(pl)//오른쪽 그룹 범위의
                rstack.push(right)//인덱스를 푸시합니다.
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("퀵 정렬")
        print("요솟수 :")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i] :")
            x[i] = readLine()!!.toInt()
        }
        quickSort(x, 0, nx - 1)
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx)
            println("x[$i]= ${x[i]}")
    }
}