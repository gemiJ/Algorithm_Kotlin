fun eraseNum(board: Array<IntArray>, num:Int): Pair<Int,Int>?{
    for (i in board.indices) {
        for (j in board.indices) {
            if (board[i][j] == num) {
                board[i][j] = 0
                return Pair(i, j)
            }
        }
    }
    return null
}

fun isBingo(loc: Pair<Int,Int>, board: Array<IntArray>): Int {
    val row = loc.first
    val col = loc.second
    var flag = true
    var addBingo = 0

    // 행 기준
    for(j in 0 until 5){
        if(board[row][j] != 0){
            flag = false
            break
        }
    }
    if (flag) addBingo++

    // 열 기준
    flag = true
    for(i in 0 until 5){
        if(board[i][col] != 0){
            flag = false
            break
        }
    }
    if (flag) addBingo++

    // 대각선 기준
    if (board[2][2] != 0) return addBingo

    // 왼쪽 위 - 오른쪽 아래 대각선
    if (row == col){
        flag = true
        for(i in 0 until 5){
            if(board[i][i] != 0){
                flag = false
                break
            }
        }
        if (flag) addBingo++
    }

    // 왼쪽 아래 - 오른쪽 위 대각선
    if (row + col == 4){
        flag = true
        for(i in 0 until 5){
            if(board[i][4-i] != 0){
                flag = false
                break
            }
        }
        if (flag) addBingo++
    }

    return addBingo
}

fun main() {
    val board = Array(5) {
        readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    }

    var res = 0
    var bingoCnt = 0
    repeat(5) {
        readLine()!!.split(" ").map { it.toInt() }.forEach { num ->
            res++
            val addBingo = isBingo(eraseNum(board, num)!!, board)
            if(addBingo>0){
                bingoCnt += addBingo
                if(bingoCnt >= 3) {
                    println(res)
                    return
                }
            }
        }
    }
}