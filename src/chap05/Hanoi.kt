package chap05

internal object Hanoi {
    //no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
    fun move(no: Int, x: Int, y: Int) {
        if (no > 1)
            move(no - 1, x, 6 - x - y)
        println("원반[$no]을 ${x}기둥에서 ${y}기둥으로 옮김")
        if (no > 1)
            move(no - 1, 6 - x - y, y)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("하노이의 탑")
        print("원반 개수 : ")
        val n = readLine()!!.toInt()
        move(n, 1, 3)//1번 기둥의 n개의 원반을 3번 기둥으로 옮김
    }
}