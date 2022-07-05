import java.util.*

data class Tomato(val h:Int, val n:Int, val m:Int, val day:Int)
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val (M, N, H) = br.readLine().split(" ").map { it.toInt() }
    val box = Array(H) { Array(N) { IntArray(M) } }
    val visited = Array(H) { Array(N) { BooleanArray(M) } }
    val queue : Queue<Tomato> = ArrayDeque()

    for(h in 0 until H){
        for(n in 0 until N){
            val input = br.readLine().split(" ").map { it.toInt() }.toIntArray()
            box[h][n] = input
            input.forEachIndexed{ m, num ->
                if(num == 1) queue.offer(Tomato(h,n,m,0))
            }
        }
    }

    val dh = intArrayOf(-1,1,0,0,0,0) // 위, 아래, 왼쪽, 오른쪽, 앞, 뒤,
    val dn = intArrayOf(0,0,0,0,-1,1)
    val dm = intArrayOf(0,0,-1,1,0,0)

    // 하루 지나면 익는다.
    var day = 0
    fun bfs(){
        while(queue.isNotEmpty()){
            val cur = queue.poll()
            day = day.coerceAtLeast(cur.day)
            visited[cur.h][cur.n][cur.m] = true
            for(k in 0 until 6){
                val nh = cur.h + dh[k]
                val nn = cur.n + dn[k]
                val nm = cur.m + dm[k]
                if((0<=nh && nh <H) && (0<=nn && nn<N) && (0<=nm && nm<M) && !visited[nh][nn][nm] && box[nh][nn][nm] == 0){
                    box[nh][nn][nm] = cur.day + 1
                    queue.offer(Tomato(nh,nn,nm,cur.day+1))
                }
            }
        }
    }

    bfs()

    // 모두 익지 않았으면
    for(h in 0 until H){
        for(n in 0 until  N) {
            if(box[h][n].contains(0)){
                println(-1)
                return
            }
        }
    }

    println("$day")
    br.close()
}