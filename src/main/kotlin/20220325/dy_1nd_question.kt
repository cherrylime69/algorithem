package `20220325`

// 이것이 취업을 위한 코딩테스트다
// p.217 1로 만들기

fun main() {

    val n = readLine()!!.toInt()
    val d = IntArray(30001) { 0 }

    for (i in 2..n) {
        d[i] = d[i - 1] + 1

        if (i % 5 == 0) {
            d[i] = minOf(d[i / 5] + 1, d[i])
        }
        if (i % 3 == 0) {
            d[i] = minOf(d[i / 3] + 1, d[i])
        }
        if (i % 2 == 0) {
            d[i] = minOf(d[i / 2] + 1, d[i])
        }
    }

    println(d[n])

}

fun myAnswer() {
    var n = readLine()!!.toInt()
    var count = 0

    while (n != 1) {
        if (n % 5 == 0) {
            n /= 5
            count++
        } else if (n % 5 == 1) {
            n--
            count++
        } else if (n % 3 == 0) {
            n /= 3
            count++
        } else if (n % 3 == 1) {
            n--
            count++
        } else if (n % 2 == 0) {
            n /= 2
            count++
        } else if (n % 2 == 1) {
            n--
            count++
        } else {
            n--
            count++
        }
    }

    println(count)
}


/*
정답 해설
이 문제는 동일한 함수에서 구하는 값들이 동일해야 하므로 다이나믹 프로그래밍이 효과적이다
점화식은 ai = minOf(ai-1, ai/2, ai/3, a/5) + 1(함수 호출 횟수를 구해야 하니 1을 더함)
각각 2, 3, 5로 나누어 떨어졌을 때만 점화식을 구하면 된다
 */