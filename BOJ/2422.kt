fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val mixableArr = Array(N + 1) { BooleanArray(N + 1) { true } }

    // 섞어먹으면 안되는 조합 입력
    repeat(M) {
        val (N1, N2) = br.readLine().split(" ").map { it.toInt() }
        mixableArr[N1][N2] = false
        mixableArr[N2][N1] = false
    }

    // 3개 조합하는 방법
    val visited = BooleanArray(N + 1) { false }
    val result = IntArray(3)
    var answer = 0
    fun combination(cur: Int, depth: Int) {
        if (depth == 3) {
            if (mixableArr[result[0]][result[1]] and mixableArr[result[1]][result[2]] and mixableArr[result[2]][result[0]]) {
                answer++
            }
            return
        }
        for (i in cur..N) {
            if (!visited[i]) {
                visited[i] = true
                result[depth] = i
                combination(i, depth + 1)
                visited[i] = false
            }
        }
    }
    combination(1, 0)
    bw.write("$answer")

    br.close()
    bw.close()
}