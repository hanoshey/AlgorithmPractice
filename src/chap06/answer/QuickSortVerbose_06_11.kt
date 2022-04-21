package chap06.answer

import kotlin.jvm.JvmStatic

internal object QuickSortVerbose_06_11 {
    // 배열의 요소 a[idx1]과 a[idx2]를 교환
    fun swap(a: IntArray, idx1: Int, idx2: Int) {
        val t = a[idx1]
        a[idx1] = a[idx2]
        a[idx2] = t
    }

    // 퀵정렬(비재귀버전)
    fun quickSort(a: IntArray, left: Int, right: Int) {
        var left = left
        var right = right
        val lstack = IntStack(right - left + 1)
        val rstack = IntStack(right - left + 1)
        lstack.push(left)
        rstack.push(right)
        print("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n".format(left, right))
        print("Lstack:")
        lstack.dump()
        print("Rstack:")
        rstack.dump()
        while (!lstack.isEmpty) {
            left = lstack.pop()
            var pl = left // 왼쪽 커서
            right = rstack.pop()
            var pr = right // 오른쪽 커서
            val x = a[(left + right) / 2] // 피벗은 중앙의 요소
            print("스택에서 분할하는 문제를 꺼냈습니다.a[%d]~a[%d]를 분할합니다.\n".format(left, right))
            do {
                while (a[pl] < x) pl++
                while (a[pr] > x) pr--
                if (pl <= pr) swap(a, pl++, pr--)
            } while (pl <= pr)
            if (left < pr) {
                lstack.push(left) // 머리쪽 그룹의 범위
                rstack.push(pr) // (index)를 푸시
                print("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n".format(left, pr))
                print("Lstack:")
                lstack.dump()
                print("Rstack:")
                rstack.dump()
            }
            if (pl < right) {
                lstack.push(pl) // 꼬리쪽그룹의 범위
                rstack.push(right) // (index)를 푸시
                print("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n".format(pl, right))
                print("Lstack:")
                lstack.dump()
                print("Rstack:")
                rstack.dump()
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("퀵정렬 ")
        print("요솟수：")
        val nx = readLine()!!.toInt()
        val x = IntArray(nx)
        for (i in 0 until nx) {
            print("x[$i]：")
            x[i] = readLine()!!.toInt()
        }
        quickSort(x, 0, nx - 1) // 배열 x를 퀵정렬
        println("오름차순으로 정렬했습니다.")
        for (i in 0 until nx) println("x[$i] = ${x[i]}")
    }
}