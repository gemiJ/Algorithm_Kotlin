import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    val N = readLine().toInt()
    val bw = System.out.bufferedWriter()
    val deque: Deque<Int> = ArrayDeque<Int>()

    repeat(N) {
        val command = readLine().split(" ")
        when (command[0]) {
            "push_front" -> deque.offerFirst(command[1].toInt())
            "push_back" -> deque.offerLast(command[1].toInt())
            "pop_front" -> if (deque.isEmpty()) bw.write("-1\n") else bw.write("${deque.pollFirst()}\n")
            "pop_back" -> if (deque.isEmpty()) bw.write("-1\n") else bw.write("${deque.pollLast()}\n")
            "size" -> bw.write("${deque.size}\n")
            "empty" -> if (deque.isEmpty()) bw.write("1\n") else bw.write("0\n")
            "front" -> if (deque.isEmpty()) bw.write("-1\n") else bw.write("${deque.peekFirst()}\n")
            "back" -> if (deque.isEmpty()) bw.write("-1\n") else bw.write("${deque.peekLast()}\n")
        }
    }
    this.close()
    bw.close()
}