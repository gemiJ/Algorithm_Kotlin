import java.lang.StringBuilder
import java.util.*

fun main()=with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val stack = Stack<Int>()
    val n = readLine().toInt()
    var sequence = readLine().toInt()

    var cnt = 1
    for(i in 1..n){
        stack.push(i)
        sb.append("+\n")

        while(sequence == stack.peek()) {
            stack.pop()
            sb.append("-\n")

            if(cnt < n){
                sequence = readLine().toInt()
                cnt++
            }

            if(stack.isEmpty()) break
        }
    }

    if(stack.isNotEmpty()){
        sb.clear()
        print("NO\n")
    }
    else{
        print(sb)
    }

    this.close()
}