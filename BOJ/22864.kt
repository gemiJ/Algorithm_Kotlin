fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (A,B,C,M) = br.readLine().split(" ").map { it.toInt() }
    var work = 0
    var fatigue = 0

    for(i in 1..24){
        if(fatigue+A <= M){
            work += B
            fatigue += A
        }
        else {
            fatigue -= C
            if(fatigue < 0) fatigue = 0
        }
    }
    bw.write(work.toString())

    br.close()
    bw.close()
}