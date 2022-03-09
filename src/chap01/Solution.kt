package chap01

//class Solution {
//    private fun combination(answer: MutableSet<List<Int>>, el: List<Int>, ck: Array<Boolean>, start: Int, target:Int) {
//        if(target == 0) {
//            answer.addAll( listOf(el.sorted().filterIndexed { index, t -> ck[index] }))
//        } else {
//            for(i in start until el.size) {
//                ck[i] = true
//                combination(answer, el, ck, i + 1, target - 1)
//                ck[i] = false
//            }
//        }
//    }
//    fun threeSum(nums: IntArray):List<List<Int>> {
//        val answer = mutableSetOf<List<Int>>()
//        for(i in 1 .. nums.size) {
//            combination(answer, nums.toList(), Array(nums.size) { false }, 0,  3)
//        }
//        answer.forEach()
//        return answer.filter { it[0]+it[1]+it[2]==0 }
//    }
//}