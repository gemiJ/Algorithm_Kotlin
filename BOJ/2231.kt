fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val N = br.readLine().toInt()
    var result = 0

    for(i in 1 until N){
        var tmp = i
        var sum = i
        while(tmp!=0){
            sum += tmp % 10
            tmp /= 10
        }
        if(sum == N){
            result = i
            break
        }
    }

    bw.write(result.toString())
    bw.close()
    br.close()
}