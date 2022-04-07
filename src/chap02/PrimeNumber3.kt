package chap02

object PrimeNumber3 {
    @JvmStatic
    fun main(args: Array<String>) {
        var counter = 0
        var ptr = 0
        val prime = IntArray(500)
        prime[ptr++] = 2
        prime[ptr++] = 3
        var n = 5
        while (n <= 1000) {//대상은 홀수만
            var flag = false
            var i = 1
            while (prime[i] * prime[i]<=n) {
                counter += 2
                if (n % prime[i] == 0) {
                    flag = true
                    break
                }
                i++
            }
            if (!flag) {
                prime[ptr++] = n
                counter++
            }
            n += 2
        }
        var i = 0
        while (i < ptr) {
            println(prime[i])
            i++
        }
        println("곱셈과 나눗셈을 수행한 횟수 : $counter")
    }
}