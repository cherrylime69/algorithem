package `20220315`

// 이것이 취업을 위한 코딩테스트다
// p.178 성적이 낮은 순서로 학생 출력하기


fun main() {

    val n = readLine()!!.toInt()
    var input = mutableMapOf<String, Int>()

    (0 until n).forEach {
        val m = readLine()!!.split(" ")
        input[m[0]] = m[1].toInt()
    }
    input = input.toList().sortedBy{it.second}.toMap().toMutableMap() // 맵을 리스트로 변환하고 리스트의 sort 메서드를 통해 정렬
    println(input.keys)
}