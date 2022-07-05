import java.util.*

lateinit var arr: Array<ArrayList<Int>>
lateinit var res: IntArray
lateinit var visited: BooleanArray

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine(), " ")
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    arr = Array(N + 1) { ArrayList() }
    repeat(M) {
        st = StringTokenizer(br.readLine(), " ")
        val A = st.nextToken().toInt()
        val B = st.nextToken().toInt()
        arr[A].add(B)
    }

    res = IntArray(N + 1)
    repeat(N) {
        visited = BooleanArray(N + 1)
        dfs(it+1)
    }

    val sb = StringBuilder()
    val maxValue = res.maxOf { it }
    for(i in 1 until res.size){
        if(res[i] == maxValue) sb.append("$i ")
    }

    println(sb)
}

fun dfs(cur: Int) {
    visited[cur] = true
    res[cur]++

    for(adj in arr[cur]){
        if(!visited[adj]) {
            dfs(adj)
        }
    }
}