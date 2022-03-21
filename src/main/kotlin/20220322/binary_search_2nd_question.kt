package `20220322`

// 이것이 취업을 위한 코딩테스트다
// p.202 떡볶이 떡 만들기

fun main() {

    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val input = readLine()!!.split(" ").map { it.toInt() }

    var start = 0
    var end = input.maxOf { it }

    var result = 0
    while (start <= end) {
        var total = 0
        var mid = (start + end) / 2

        for (i in input) {
            if (i > mid)
                total += i - mid
        }
            if (total < m)
                end = mid - 1
            else {
                result = mid
                start = mid + 1
            }
        }

    println(result)

}
// 내가 쓴 답
fun binary(list: List<Int>, target: Int, start: Int, end: Int): Int {
    var start = list[start]
    var end = list[end]

    while (start <= end) {
        var total = 0
        var mid = (start + end) / 2

        for (i in list) {
            if (i > mid)
                total += i - mid
        }
        if (total == target)
            return mid

        if (total < target)
            end = mid - 1
        else
            start = mid + 1
    }
    return 0
}


/*
정답 해설:
절단기의 높이를 이진 탐색을 통해 구하면 됨 -> 이 문제는 전형적인 파라메트릭 서치 문제
최대 탐색 범위가 10억까지 정수이며, 이진 탐색을 이용하면 약 31번 만에 경우의 수를 모두 고려할 ㅅ ㅜ있음
이진 탐색을 구현하면 제한 시간 2초 내에 떡의 개수가 최대 100만 개이기 때문에 최악의 경우 3,000만번을 연산하기 때문에 정답을 도출할 수 있음
필요한 떡이 자른 떡보다 길면 떡을 더 많이 잘라야 하므로 왼쪽 탐색
필요한 떡이 자른 떡보다 짧으면 떡을 덜 잘라야 하므로 오른쪽 탐색
최댓값을 구하기 때문에 오른쪽 탐색을 할때마다 정답을 갱신
 */