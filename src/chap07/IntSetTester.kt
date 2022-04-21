package chap07

internal object IntSetTester {
    @JvmStatic
    fun main(args: Array<String>) {
        val s1 = IntSet(20)
        val s2 = IntSet(20)
        val s3 = IntSet(20)

        s1.add(10)
        s1.add(15)
        s1.add(20)
        s1.add(25)
        s1.copyTo(s2)//s2={10,15,20,25}
        s2.add(12)
        s2.remove(25)
        s3.copyFrom(s2)//s3={10,15,20,12}
        println("s1=$s1")
        println("s2=$s2")
        println("s3=$s3")
        println("집합 s1에 15는 ${if (s1.contains(15)) "포함됩니다" else "포함되지 않습니다."}")
        println("집합 s2에 25는 ${if (s2.contains(25)) "포함됩니다" else "포함되지 않습니다."}")
        println("집합 s1과 s2는 ${if (s1.equalTo(s2)) "같습니다" else "같지 않습니다."}")
        println("집합 s2와 s3는 ${if (s2.equalTo(s3)) "같습니다" else "같지 않습니다."}")
        s3.unionOf(s1, s2)//s3<- s1 U s2
        println("집합 s1과 s2의 합집합은 ${s3}입니다.")
    }
}