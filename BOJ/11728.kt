fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (N, M) = br.readLine()!!.split(" ").map { it.toInt() }
    val A = br.readLine()!!.split(" ").map { it.toInt() }
    val B = br.readLine()!!.split(" ").map { it.toInt() }

    var idxA = 0
    var idxB = 0
    for (i in 0 until N + M) {
        if (idxA == A.size) {
            B.forEachIndexed { idx, value -> if (idx >= idxB) bw.write("$value ") }
            break
        }
        if (idxB == B.size) {
            A.forEachIndexed { idx, value -> if (idx >= idxA) bw.write("$value ") }
            break
        }
        if (A[idxA] < B[idxB]) {
            bw.write("${A[idxA]} ")
            idxA++
        } else if (A[idxA] > B[idxB]) {
            bw.write("${B[idxB]} ")
            idxB++
        } else if (A[idxA] == B[idxB]) {
            bw.write("${A[idxA]} ")
            bw.write("${B[idxB]} ")
            idxA++
            idxB++
        }
    }

    br.close()
    bw.close()
}