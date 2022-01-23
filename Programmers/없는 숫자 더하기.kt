class Solution {
    fun solution(numbers: IntArray): Int {
        var answer = 0
        val numberArr = BooleanArray(10) { false }
        for(number in numbers)
            numberArr[number] = true
        for(i in numberArr.indices)
            if(!numberArr[i])
                answer += i

        return answer
    }
}

fun main(){
    val solutionClass = Solution()
    val numbers = intArrayOf(1,2,3,4,6,7,8,0)
    val answer = solutionClass.solution(numbers)
    print(answer)
}