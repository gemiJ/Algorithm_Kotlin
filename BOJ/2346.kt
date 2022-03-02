import java.util.*
fun main() = with(System.`in`.bufferedReader()){
    val bw = System.out.bufferedWriter()
    val deque : Deque<Pair<Int,Int>> = ArrayDeque()
    readLine().toInt()
    val input = readLine().split(" ").map { it.toInt() }.toList()

    for((idx,data) in input.withIndex()){
        deque.add(idx+1 to data)
    }

    while(true){
        val peek = deque.peek().second
        bw.write("${deque.peek().first} ")
        deque.pop()
        if(deque.isEmpty()) break
        when{
            peek > 0 -> repeat(peek-1){deque.offer(deque.poll())}
            peek < 0 -> repeat(-peek){deque.offerFirst(deque.pollLast())}
        }
    }

    bw.close()
    this.close()
}