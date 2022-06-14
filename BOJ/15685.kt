val dx = intArrayOf(0, -1, 0, 1) // 우, 상, 좌, 하
val dy = intArrayOf(1, 0, -1, 0)
val visited = Array(101) { BooleanArray(101) { false } }
fun main() {
    val N = readLine()!!.toInt()
    repeat(N) {
        // 드래곤 커브
        val (y, x, d, g) = readLine()!!.split(" ").map { it.toInt() }

        // 드래곤 커브 방향 찾기
        val dList = mutableListOf(d)
        repeat(g) {
            val tmp = mutableListOf<Int>()
            tmp.addAll(dList)
            tmp.forEachIndexed { index, i -> tmp[index] = (i + 1) % 4 }
            tmp.reverse()
            dList.addAll(tmp)
        }

        // 방문 표시
        visited[x][y] = true
        var cx = x
        var cy = y
        for (d in dList) {
            cx += dx[d]
            cy += dy[d]
            visited[cx][cy] = true
        }
    }

    // 모든 드래곤 커브 방문 후 정사각형 개수
    var res = 0
    (0..99).forEach { i ->
        (0..99).forEach { j ->
            if (visited[i][j] && visited[i + 1][j] && visited[i][j + 1] && visited[i + 1][j + 1])
                res++
        }
    }

    print(res)
}