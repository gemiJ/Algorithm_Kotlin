lateinit var tree: Array<ArrayList<Int>>
lateinit var visited: BooleanArray
lateinit var res: IntArray
fun DFS(curNode: Int, nodeCnt: Int){
    for(next in tree[curNode]){
        if(!visited[next]){
            visited[next] = true
            res[next] = curNode
            DFS(next, nodeCnt)
            visited[next] = false
        }
    }
}

fun main() {
    val N = readLine()!!.toInt()
    res = IntArray(N + 1) { 0 }
    tree = Array(N + 1){ ArrayList(0) }
    visited = BooleanArray(N+1){false}
    repeat(N - 1) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        tree[x].add(y)
        tree[y].add(x)
    }

    visited[1] = true
    DFS(1, N)

    res.drop(2).forEach { println(it) }
}