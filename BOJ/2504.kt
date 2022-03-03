import java.util.*

/*
    1. 중복되는 종료 코드를 flag를 통해 한번에 처리해도 될 것 같다.
        ex) 함수 생성 후 exitProcess(0)를 통해 프로그램 종료 등..
    2. 더 간단하게 풀이할 수 있는 방법을 생각해보기. 코드가 너무 복잡하다.
*/

fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val input = readLine().toMutableList()
    val postfix: MutableList<Char> = mutableListOf()
    val op: Stack<Char> = Stack<Char>()
    val st: Stack<Int> = Stack<Int>()

    // 입력 값이 한개일 경우
    if(input.size==1) {
        bw.write("0\n")
        bw.close()
        return
    }

    // 첫번쨰 값 넣기
    when(input[0]){
        '(' -> {
            postfix.add('2')
            op.push('(')
        }
        '[' -> {
            postfix.add('3')
            op.push('[')
        }
        else -> {
            bw.write("0\n")
            bw.close()
            return
        }
    }
    // 중위표기식을 후위표기식으로 변환
    for (i in 1 until input.size){
        when(input[i]){
            '(' -> {
                postfix.add('2')
                when(input[i-1]){
                    '(','[' -> op.push('*')
                    ')',']' -> op.push('+')
                }
                op.push('(')
            }
            '[' -> {
                postfix.add('3')
                when(input[i-1]){
                    '(','[' -> op.push('*')
                    ')',']' -> op.push('+')
                }
                op.push('[')
            }
            ')' -> {
                if(input[i-1] == '[' ) {
                    bw.write("0\n")
                    bw.close()
                    return
                }
                var flag = false
                while(op.isNotEmpty()){
                    if(op.peek()=='('){
                        op.pop()
                        flag = true
                        break
                    }
                    postfix.add(op.pop())
                }
                if(!flag){
                    bw.write("0\n")
                    bw.close()
                    return
                }
            }
            ']' -> {
                if(input[i-1] == '(') {
                    bw.write("0\n")
                    bw.close()
                    return
                }
                var flag = false
                while(op.isNotEmpty()){
                    if(op.peek()=='['){
                        op.pop()
                        flag = true
                        break
                    }
                    postfix.add(op.pop())
                }
                if(!flag){
                    bw.write("0\n")
                    bw.close()
                    return
                }
            }
        }
    }
    
    // 남은 연산자 모두 삽입
    while(op.isNotEmpty()){
        when(op.peek()){
            '(','[' -> {
                bw.write("0\n")
                bw.close()
                return
            }
            else -> postfix.add(op.pop())
        }
    }

    // 후위표기식 계산
    postfix.forEach {
        when(it){
            '+' -> {
                val op1 = st.peek()
                st.pop()
                val op2 = st.peek()
                st.pop()
                st.push((op1+op2))
            }
            '*' -> {
                val op1 = st.peek()
                st.pop()
                val op2 = st.peek()
                st.pop()
                st.push((op1*op2))
            }
            else -> st.push(Character.getNumericValue(it))
        }
    }

    // 결과
    bw.write("${st.peek()}\n")

    bw.close()
    this.close()
}