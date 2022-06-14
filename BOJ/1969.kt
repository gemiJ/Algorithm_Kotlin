data class DS(val ch: Char, var sum: Int)

fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val dna = ArrayList<String>()
    repeat(N) {
        dna.add(readLine()!!)
    }

    var resDna = ""
    var resSum = 0
    for (j in 0 until M) {
        val sumArr = arrayOf(DS('A', 0), DS('T', 0), DS('G', 0), DS('C', 0))
        for (i in 0 until N) {
            when (dna[i][j]) {
                'A' -> sumArr[0].sum++
                'T' -> sumArr[1].sum++
                'G' -> sumArr[2].sum++
                'C' -> sumArr[3].sum++
            }
        }
        sumArr.sortByDescending { it.sum } // 내림차순
        val max = sumArr[0].sum
        val equalArr = sumArr.filter { it.sum == max }.sortedBy { it.ch } // 사전순
        resDna += equalArr[0].ch
        resSum += (N - equalArr[0].sum)
    }

    println(resDna)
    println(resSum)
}