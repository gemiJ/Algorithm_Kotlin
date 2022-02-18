import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var N = readLine()!!.toInt()
    val stack = Stack<Int>()
    while(N-- != 0){
        val command = readLine().split(" ")
        when(command[0]){
            "push" -> stack.push(command[1].toInt())
            "pop" -> if(stack.isEmpty()) println("-1") else println(stack.pop())
            "top" -> if(stack.isEmpty()) println("-1") else println(stack.peek())
            "size" -> println(stack.size)
            "empty" -> if(stack.isEmpty()) println("1") else println("0")
        }
    }
}