fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val cards = br.readLine().split(" ").map { it.toInt() }
    var result = 0

    loop@ for(i in 0 until cards.size - 2)
        for (j in i+1 until cards.size-1)
            for(k in j+1 until cards.size){
                val sum = cards[i]+cards[j]+cards[k]
                if(sum == M){
                    result = sum
                    break@loop
                }
                else if(sum in (result + 1) until M){
                    result = sum
                }
                else continue
            }

    bw.write(result.toString())

    br.close()
    bw.close()
}