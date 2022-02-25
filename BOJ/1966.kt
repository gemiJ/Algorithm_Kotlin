import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    val bw = System.out.bufferedWriter()
    var T = readLine().toInt()

    repeat(T){
        val (N, M) = readLine().split(" ").map { it.toInt() }
        // PriorityQueue 는 해당 숫자가 가장 큰지 판단하기 위함
        val pq: PriorityQueue<Int> = PriorityQueue(Comparator.reverseOrder())
        // Queue 는 입력에 따라 횟수를 계산하기 위함
        val queue: Queue<Pair<Int, Boolean>> = ArrayDeque()
        val numbers = readLine().split(" ").map { it.toInt() }.toMutableList()
        for((idx, num) in numbers.withIndex()) {
            if (idx == M) queue.add(Pair(num, true)) else queue.add(Pair(num, false))
            pq.add(num)
        }
        var result = 0
        while (pq.isNotEmpty()) {
            if(pq.peek()==queue.peek().first){
                pq.poll()
                if(queue.peek().second){
                    queue.poll()
                    result++
                    bw.write("$result\n")
                    break
                }
                else{
                    queue.offer(queue.poll())
                    result++
                }
            }
            else{
                queue.offer(queue.poll())
            }
        }
    }
    bw.close()
    this.close()
}