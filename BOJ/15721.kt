fun main() {
    val A = readLine()!!.toInt()
    val T = readLine()!!.toInt()
    val G = readLine()!!.toInt() // 뻔 : 0, 데기 : 1

    var round = 0
    var count = 0
    var seat = 0
    while (true) {
        round++
        val arr = arrayListOf(0, 1, 0, 1) // 뻔 - 데기 - 뻔 - 데기
        repeat(round + 1) { arr.add(0) } // 뻔(* n + 1)
        repeat(round + 1) { arr.add(1) } // 데기(* n + 1)
        for (data in arr) {
            if (data == G) count++
            if (count == T) {
                println(seat)
                return
            }
            seat++
            seat %= A
        }
        arr.clear()
    }
}