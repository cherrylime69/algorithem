package `20220315`

// 이것이 취업을 위한 코딩테스트다
// p.182 두 배열의 원소 교체

fun main() {
    val (n, m) = readLine()!!.split(" ").map {it.toInt()}
    val a = readLine()!!.split(" ").map{it.toInt()}.sorted().toMutableList()
    val b = readLine()!!.split(" ").map{it.toInt()}.sortedDescending().toMutableList()

    (0 until m).forEach {
        if (a[it] < b[it])
        a[it] = b[it]
        else return@forEach
    }

    val hap = a.sum()
    println(hap)



}
