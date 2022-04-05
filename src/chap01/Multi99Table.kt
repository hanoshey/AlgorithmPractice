package chap01

object Multi99Table{
    @JvmStatic
    fun main(args:Array<String>){
        println("----- 곱셈표 -----")
        for(i in 1..9){
            for(j in 1..9)
                print("%3d".format(i*j))
            println()
        }
    }
}