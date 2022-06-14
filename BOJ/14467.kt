fun main() {
    val N = readLine()!!.toInt()
    val cowMap = mutableMapOf<Int, Int>()
    var res = 0
    repeat(N) {
        val (cow, loc) = readLine()!!.split(" ").map { it.toInt() }
        if (cowMap.containsKey(cow)) {
            if (cowMap[cow] != loc) {
                cowMap[cow] = loc
                res++
            }
        }
        else {
            cowMap[cow] = loc
        }
    }
    println(res)
}