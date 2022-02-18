import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    val (N,K) = readLine().split(" ").map { it.toInt() }

    var linkedList = LinkedList<Int>()
    var result = mutableListOf<Int>()

    for(i in 1..N) linkedList.add(i)

    while(linkedList.isNotEmpty()){
        for(i in 1 until K) {
           linkedList.offer(linkedList.poll())
        }
        result.add(linkedList.poll())
    }

    print(result.joinToString(", ","<",">"))

}