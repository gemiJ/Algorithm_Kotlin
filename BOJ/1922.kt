import java.util.*

data class Edge(val start: Int, val end: Int, val weight: Int)
fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val N = br.readLine()!!.toInt()
    val M = br.readLine()!!.toInt()
    val pq = PriorityQueue<Edge>(compareBy({it.weight}))
    val parent = IntArray(N+1){ it }

    repeat(M){
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        pq.offer(Edge(a, b, c))
    }

    fun find(start: Int) : Int {
        if(parent[start] == start)
            return start
        else {
            parent[start] = find(parent[start])
            return parent[start]
        }
    }

    fun union(start: Int, end: Int){
        val ps = find(start)  // 양쪽 부모 노드 찾아서 start쪽에 합쳐줌
        val end = find(end)
        parent[end] = ps
    }

    var cnt = 0
    var sum = 0
    while(pq.isNotEmpty()){
        if(cnt == N-1) break
        val cur = pq.poll()
        // 간선에 연결된 두 노드가 같은 유니온 내에 있지 않다면 연결해주기
        if(find(cur.start) == find(cur.end)) continue
        else {
            union(cur.start, cur.end)
            cnt ++
            sum += cur.weight
        }
    }

    bw.write("$sum")
    br.close()
    bw.close()

}