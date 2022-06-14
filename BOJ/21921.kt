fun main() {
    val (N, X) = readLine()!!.split(" ").map { it.toInt() }
    val visitor = readLine()!!.split(" ").map { it.toInt() }

    var start = 0
    var end = X-1
    var sum = visitor.take(X).sum()
    var maxSum = 0
    var count = 0
    while(true){
        if(sum > maxSum) {
            maxSum = sum
            count = 1
        }
        else if(sum == maxSum) {
            count++
        }
        start++
        end++
        if(end == N) break
        else sum += (visitor[end] - visitor[start - 1])
    }

    if(maxSum == 0) println("SAD")
    else {
        println(maxSum)
        println(count)
    }
}