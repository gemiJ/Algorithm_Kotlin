fun main(){
    var n = readLine()!!.toInt()
    var dp = IntArray(50001) {0}
    dp[3] = 1
    dp[5] = 1
    for(i in 6 .. n){
        if(dp[i-3] > 0) dp[i] = dp[i-3] + 1
        if(dp[i-5] > 0) dp[i] =
            if(dp[i] > 0) Math.min(dp[i], dp[i-5] + 1)
            else dp[i-5] + 1
    }

    if(dp[n]>0) println(dp[n]) else println(-1)
}