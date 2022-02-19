import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    var N = readLine()!!.toInt()
    val queue = LinkedList<Int>()
    repeat(N) {
        val command = readLine().split(" ")
        when (command[0]) {
            "push" -> queue.add(command[1].toInt())
            "pop" -> if (queue.isEmpty()) bw.write("-1\n") else bw.write("${queue.pollFirst()}\n")
            "size" -> bw.write("${queue.size}\n")
            "empty" -> if (queue.isEmpty()) bw.write("1\n") else bw.write("0\n")
            "front" -> if (queue.isEmpty()) bw.write("-1\n") else bw.write("${queue.peekFirst()}\n")
            "back" -> if (queue.isEmpty()) bw.write("-1\n") else bw.write("${queue.peekLast()}\n")
        }
    }
    this.close()
    bw.close()
}