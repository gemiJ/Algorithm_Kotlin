class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int =
        absolutes.foldIndexed(0) {index, acc, i -> acc + if(signs[index]) i else -i }
}

fun main(){
    val absolutes = intArrayOf(4,7,12)
    val signs = booleanArrayOf(true,false,true)
    val result = Solution().solution(absolutes , signs)
    print(result)
}