fun main(){
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    var hour = 0
    var minute = 0
    var sec = 0
    var res = 0
    repeat((N+1) * 60 * 60){
        if(sec == 60){
            sec = 0
            minute++
        }
        if(minute == 60){
            minute = 0
            hour++
        }
        val time = (String.format("%02d", hour)) +(String.format("%02d", minute)) + (String.format("%02d", sec))
        if(time.contains(K.toString())){
            res++
        }
        sec++
    }
    println(res)
}
