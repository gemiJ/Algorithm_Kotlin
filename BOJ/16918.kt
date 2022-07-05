import java.util.*

fun main() {
    val dy = intArrayOf(-1, 1, 0, 0) // 상, 하, 좌, 우
    val dx = intArrayOf(0, 0, -1, 1)

    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val (R, C, N) = br.readLine().split(" ").map { it.toInt() }

    val graph: Array<ArrayList<Int>> = Array(R) { ArrayList() }
    for (i in 0 until R) {
        val input = br.readLine().toCharArray()
        input.forEach {
            if (it == 'O') graph[i].add(0)
            else graph[i].add(-1)
        }
    }

    for (sec in 2..N) {
        if (sec % 2 == 0) { // 폭탄 없는 칸에 설치
            for (i in 0 until R) {
                for (j in 0 until C) {
                    if (graph[i][j] == -1) {
                        graph[i][j] = sec
                    }
                }
            }
        }

        if (sec % 2 == 1) { // -3초전에 설치된 폭탄 폭발
            val tmp: Array<ArrayList<Int>> = Array(R) { arrayListOf() }
            for (i in 0 until R) {
                tmp[i].addAll(graph[i])
            }
            for (i in 0 until R) {
                for (j in 0 until C) {
                    if (graph[i][j] != -1 && graph[i][j] <= sec - 3) {
                        tmp[i][j] = -1
                        for (k in 0 until 4) {
                            val ny = i + dy[k]
                            val nx = j + dx[k]
                            if (0 <= ny && ny < R && 0 <= nx && nx < C) tmp[ny][nx] = -1
                        }
                    }
                }
            }

            for (i in 0 until R) {
                graph[i].clear()
                graph[i].addAll(tmp[i])
            }
        }
    }

    for (i in 0 until R) {
        for (j in 0 until C) {
            if (graph[i][j] == -1) bw.write(".")
            else bw.write("O")
        }
        bw.write("\n")
    }

    br.close()
    bw.close()
}