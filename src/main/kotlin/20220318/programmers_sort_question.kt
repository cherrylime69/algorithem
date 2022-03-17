package `20220318`

// 프로그래머스 가장 큰 수
// https://programmers.co.kr/learn/courses/30/lessons/42746

// 참고한 블로그 (https://minnnne.tistory.com/73)
// 코틀린스러운 답 https://doojuns-ordinary.tistory.com/14

fun main() {

    val numbers = listOf(3, 30, 34, 5, 9)
    val b = numbers.map {it.toString()}.toMutableList()
    var c = mutableListOf<List<String>>()
    var count = ""
    var length = 0
    var answer = ""

    b.forEach {
        length = it.length
        count = it.repeat(4)
//        count = it + it + it + it
        c.add(listOf(length.toString(), count.substring(0, 4)))
    }
    println(c)
    c.sortByDescending { it[1] }

    println(c)

    for ((len, str) in c) {
        answer += str.substring(0, len.toInt())
    }

    println(answer)

    for (i in answer) {
        if (i != '0') {
            println(answer)
        }
    }
    println("0")

}


class Solution {
    fun solution(numbers: IntArray): String {
        val b = numbers.map {it.toString()}.sortedByDescending {it[0]}.toMutableList()
        var i = 0
        println(b)

        for (i in 0 until b.size - 1) {
            if ((b[i][0] > b[i+1][0])) continue
            for (j in i until b.size -1) {
                if ((b[i][0] > b[j+1][0])) continue
                if ((b[i]+b[j+1]).toInt() < ((b[j+1]+b[i]).toInt())) {
                    val tem = b[i]
                    b[i] = b[j+1]
                    b[j+1] = tem
                    continue
                }
            }
        }
        var answer =""
        b.forEach {
            answer += it
        }
        return answer
    }
}
