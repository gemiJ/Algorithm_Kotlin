import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var T = readLine().toInt()
    while (T-- != 0) {
        val ps = readLine()
        var stack = Stack<Char>()
        var flag = true
        for( c in ps) {
            when (c) {
                '(' -> stack.push('(')
                ')' -> {
                    if (stack.isNotEmpty())
                        stack.pop()
                    else {
                        flag = false
                        break
                    }
                }
            }
        }
        if (flag && stack.isEmpty())
            println("YES")
        else
            println("NO")

    }
}