package `20220321`

// 이것이 취업을 위한 코딩테스트다
// p.197 부품찾기

fun main() {
    val n = readLine()!!.toInt()
    val items = readLine()!!.split(" ").map {it.toInt()}.toMutableList()
    val m = readLine()!!.toInt()
    val inputItem = readLine()!!.split(" ").map {it.toInt()}
    val answer = arrayListOf<String>()

    items.sort()

    for (i in inputItem) {
        answer.add(binary(items, i, 0, items.size - 1))
    }

    println(answer)

}

fun binary(list: MutableList<Int>, target: Int, start: Int, end: Int): String {
    var initStart = start
    var initEnd = end
    while (initStart <= initEnd) {
        val mid = (initStart + initEnd) / 2
        if (list[mid] == target)
            return "yes"
        if (list[mid] > target)
            initEnd = mid - 1
        else
            initStart = mid + 1
    }
    return "no"
}