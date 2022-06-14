fun main(){
    val vowels = arrayOf('a','e','i','o','u')
    while (true){
        val pwd = readLine()!!.toString()
        if(pwd == "end") break
        var res = true
        for (v in vowels){
            if(pwd.contains(v)) { // 1. 모음 하나 반드시 포함
                res = true
                var sameCnt = 1
                var vcCnt = 1
                var v = vowels.contains(pwd[0])
                for (i in 1 until pwd.length){

                    // 2. 모음 3개 연속, 자음 3개 연속 여부
                    if(vowels.contains(pwd[i])){ // 현재 모음
                        if(v) vcCnt++ // 이전에 모음
                        else vcCnt = 1
                    }
                    else{ // 현재 자음
                        if(!v) vcCnt++ // 이전에 자음
                        else vcCnt = 1
                    }
                    v = vowels.contains(pwd[i])

                    if (vcCnt >= 3) {
                        res = false
                        break
                    }

                    // 3. 같은 글자 여부
                    if(pwd[i] == pwd[i-1]) {
                        sameCnt++
                    }
                    else{
                        sameCnt = 1
                    }

                    if(sameCnt >= 2 && pwd[i]!='e' && pwd[i]!='o'){
                        res = false
                        break
                    }
                    else if(sameCnt >= 3){
                        res = false
                        break
                    }
                }
                break
            } else{
                res = false
            }
        }
        if(res) println("<$pwd> is acceptable.")
        else println("<$pwd> is not acceptable.")
    }
}