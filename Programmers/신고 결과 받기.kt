class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer = IntArray(id_list.size) { 0 }
        var receiveReport = IntArray(id_list.size) { 0 }
        var sendReport = Array(id_list.size) { BooleanArray(id_list.size) { false } }

        for(data in report.distinct()){
            val userArr = data.split(" ")
            val sendIdx = id_list.indexOf(userArr[0])
            val receiveIdx = id_list.indexOf(userArr[1])
            receiveReport[receiveIdx] ++;
            sendReport[sendIdx][receiveIdx] = true
        }

        for((receiver, value) in receiveReport.withIndex()){
            if(value>=k){
                for(i in id_list.indices){
                    if(sendReport[i][receiver]){
                        answer[i]++;
                    }
                }
            }
        }

        return answer
    }
}

fun main(){
    Solution().solution(arrayOf("con", "ryan"),	arrayOf("ryan con", "ryan con", "ryan con", "ryan con"), 3).forEach { println(it) }
}