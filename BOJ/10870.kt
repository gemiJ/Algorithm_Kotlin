fun main(){
    val n = readLine()!!.toInt()
    val arr = IntArray(21) { 0 }
    arr[0] = 0
    arr[1] = 1
    for(i in 2 until arr.size){
        arr[i] = arr[i-1] + arr[i-2]
    }
    println(arr[n])
}