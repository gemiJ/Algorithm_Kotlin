import java.util.*

fun main() = with(System.`in`.bufferedReader()) {

    val input = readLine()
    val stack = Stack<Char>()
    var result = 0

    for ((index, value) in input.withIndex()) {
        when (value) {
            '(' -> stack.push('(')
            ')' ->
                if (input[index - 1] == '(') { //이전 입력이 '('일 경우 레이저
                    stack.pop()
                    result += stack.size // 레이저를 제외한 '('의 개수를 더해준다
                } else { //이전 입력이 레이저가 아닐 경우 막대의 끝을 의미
                    stack.pop()
                    result++ //막내의 끝에 마지막 조각 하나를 더해준다
                }
        }
    }
    println(result)
    this.close()
}