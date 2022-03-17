fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val input = br.readLine().split(" ").map { it.toInt() }

    val a = input['a' - 'a']
    val b = input['b' - 'a']
    val c = input['c' - 'a']
    val d = input['d' - 'a']
    val e = input['e' - 'a']
    val f = input['f' - 'a']

    /*
        행렬로 생각
        |a b| |x| = |c|
        |d e| |y|   |f|

        역행렬 계산
        |x| = |a b|-1 |c|
        |y|   |d e|   |f|
    */

    val x = (e*c - b*f) / (a*e-b*d)
    val y = (-d*c + a*f) / (a*e-b*d)

    bw.write("$x $y")

    bw.close()
    br.close()
}
