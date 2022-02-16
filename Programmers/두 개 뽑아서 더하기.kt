class Solution {
    fun solution(numbers: IntArray): IntArray {
        val arr: MutableList<Int> = mutableListOf()
        for(i in 0 until numbers.size-1){
            for(j in i+1 until numbers.size){
                arr.add(numbers[i]+numbers[j])
            }
        }
        return arr.distinct().sorted().toIntArray()
    }
}

fun main(args: Array<String>) {
    val answer = Solution().solution(intArrayOf(2,1,3,4,1))
    for (i in answer) print("$i ")
}