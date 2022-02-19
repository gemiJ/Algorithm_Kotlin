import java.util.*
fun main() = with(System.`in`.bufferedReader()){
    val bw = System.`out`.bufferedWriter()
    val N = readLine().toInt()
    val deque = LinkedList<Int>()

    repeat(N){
        deque.add(it + 1)
    }
    while (deque.size > 1){
        deque.poll()
        deque.offerLast(deque.poll())
    }

    bw.write("${deque.poll()}")

    this.close()
    bw.close()
}