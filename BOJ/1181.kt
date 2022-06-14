fun main() {
    val N = readLine()!!.toInt()
    val arr = Array(N) {
        readLine()!!.toString()
    }

    arr.sortWith(compareBy<String> { it.length }.thenBy { it })
    arr.toSet().forEach { println(it) }
}