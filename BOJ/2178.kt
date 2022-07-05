import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(N) { br.readLine().toCharArray().map { it.digitToInt() } }

    val dy = intArrayOf(-1, 1, 0, 0) // 상 하 좌 우
    val dx = intArrayOf(0, 0, -1, 1)
    val visited = Array(N) { IntArray(M) { -1 } }
    val queue: Queue<Pair<Int, Int>> = ArrayDeque()
    queue.offer(Pair(0, 0))
    visited[0][0] = 1

    fun bfs() {
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            val cy = cur.first
            val cx = cur.second
            if (cy == N - 1 && cx == M - 1) return
            for (k in 0 until 4) {
                val ny = cy + dy[k]
                val nx = cx + dx[k]
                if (0 <= ny && ny < N && 0 <= nx && nx < M && visited[ny][nx] == -1 && graph[ny][nx] == 1) {
                    queue.offer(Pair(ny, nx))
                    visited[ny][nx] = visited[cy][cx] + 1
                }
            }
        }
    }

    bfs()
    bw.write("${visited[N - 1][M - 1]}")

    bw.close()
    br.close()
}