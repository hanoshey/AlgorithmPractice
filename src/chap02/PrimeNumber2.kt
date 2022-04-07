package chap02

object PrimeNumber2 {
    @JvmStatic
    fun main(args: Array<String>) {
        var counter = 0
        var ptr = 0
        val prime = IntArray(500)
        prime[ptr++] = 2//2는 소수이다.
        var n = 3
        while (n <= 1000) {
            var i = 1
            while (i < ptr) {
                counter++
                if (n % prime[i] == 0)
                    break
                i++
            }
            if (ptr == i)
                prime[ptr++] = n
            n += 2
        }
        var i = 0
        while (i < ptr) {
            println(prime[i])
            i++
        }
        println("나눗셈을 수행한 횟수 : $counter")
    }
}