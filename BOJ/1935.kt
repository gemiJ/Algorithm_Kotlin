import java.util.*

fun divide(op1: Double, op2: Double) = op2/op1
fun minus(op1: Double, op2: Double) = op2-op1

fun main() = with(System.`in`.bufferedReader()){

    // 후위 표기식
    // A+(B*C)-D/E

    // 입력
    val N = readLine().toInt()
    val input = readLine()
    val numbers = mutableListOf<Int>()
    repeat(N) { numbers.add(readLine().toInt())}

    val stack = Stack<Double>()
    for(x in input){
        when(x){
            in 'A'..'Z' -> stack.push(numbers[x -'A'].toDouble())
            '+' -> stack.push(stack.pop() + stack.pop())
            '-' -> stack.push(minus(stack.pop(), stack.pop()))
            '*' -> stack.push(stack.pop() * stack.pop())
            '/' -> stack.push(divide(stack.pop(), stack.pop()))
        }
    }

    print("%.2f".format(stack.pop()))
}