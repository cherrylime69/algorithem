package `20220315`

// 이것이 취업을 위한 코딩테스트다
// p.178 위에서 아래로

fun main() {
    val n = readLine()!!.toInt()
    var input = IntArray(n)
    (0 until n).forEach {
        input[it] = readLine()!!.toInt()
    }

    input.sortDescending()
    val b = input.sortedArrayDescending().toList()
    val a  = input.toList()
    println(a)
    println(b)
}