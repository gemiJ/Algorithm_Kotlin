import java.util.*

var input : MutableList<Char> = mutableListOf()
lateinit var visited : MutableList<Boolean>
var op : MutableList<Pair<Int,Int>> = mutableListOf() // 괄호 쌍의 위치 저장
val result : MutableList<String> = mutableListOf() // 결과 수식 저장

fun DFS(x : Int){ // dfs
    if(op.size == x){
        var tmp = ""
        for(i in input.indices){
            if(!visited[i]){
                tmp += input[i]
            }
        }
        result.add(tmp)
        return
    }
    DFS(x+1)
    visited[op[x].first] = true
    visited[op[x].second] = true

    DFS(x+1)
    visited[op[x].first] = false
    visited[op[x].second] = false
}

fun main() = with(System.`in`.bufferedReader()){
    val bw = System.out.bufferedWriter()
    input = readLine().toMutableList()
    visited = MutableList(input.size) { false }
    val st : Stack<Int> = Stack<Int>()

    for ((idx,c) in input.withIndex()) {
        when(c){
           '(' -> st.push(idx)
            ')' -> {
                op.add(st.peek() to idx)
                st.pop()
            }
        }
    }

    DFS(0)
    result.distinct().filterNot{ it == input.joinToString("")}.sorted().forEach { bw.write("$it\n") }

    bw.close()
    this.close()
}