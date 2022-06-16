import java.util.*

lateinit var connect: Array<BooleanArray>
lateinit var visited: BooleanArray
var q = ArrayDeque<Int>()
fun main() {
    val N = readLine()!!.toInt()
    val P = readLine()!!.toInt()

    connect = Array(N + 1) { BooleanArray(N + 1) }
    visited = BooleanArray(N + 1)
    repeat(P) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        connect[x][y] = true
        connect[y][x] = true
    }

    q.offer(1)
    while (q.isNotEmpty()) {
        val cur = q.poll()
        visited[cur] = true
        (1 .. N).forEach { next ->
            if(connect[cur][next] && !visited[next]) q.add(next)
        }
    }

    println(visited.count { it } - 1)
}