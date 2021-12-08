class Solution {
    fun solution(record: Array<String>): Array<String> {

        val userMap = mutableMapOf<String, String>()
        val log = mutableListOf<Pair<String, String>>()

        for(data in record){
            val tmpArr = data.split(" ")
            when (tmpArr[0]){
                "Enter" -> {
                    userMap[tmpArr[1]] = tmpArr[2]
                    log.add(Pair(tmpArr[0], tmpArr[1]))
                }
                "Leave" -> log.add(Pair(tmpArr[0], tmpArr[1]))
                "Change" -> userMap.replace(tmpArr[1], tmpArr[2])
            }
        }

        var answerList = arrayListOf<String>()
        for((op, uid) in log){
            when (op){
                "Enter" -> answerList.add( "${userMap[uid]}님이 들어왔습니다." )
                "Leave" -> answerList.add( "${userMap[uid]}님이 나갔습니다." )
            }
        }

        var answer = answerList.toTypedArray()
        return answer
    }
}

fun main(){
    val solutionClass = Solution()
    val record = arrayOf("Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan")
    val answer = solutionClass.solution(record)
    answer.forEach { println(it) }
}