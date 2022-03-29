package `20220330`

// 이것이 취업을 위한 코딩테스트다
// p.220 개미전사

fun main() {
    val n = readLine()!!.toInt()
    val m = readLine()!!.split(" ").map { it.toInt() }
    val d = IntArray(100) { 0 }

    d[0] = m[0]
    d[1] = maxOf(m[0], m[1])

    for (i in 2 until n) {
        d[i] = maxOf(d[i - 1], d[i - 2] + m[i])
    }

    println(d[n - 1])
}

/*
정답 해설
왼쪽에서부터 식량을 얻는다고 가정함
선택지는 i번째 식량창고를 털지 안털지를 정해야함
i-1번째 식량창고를 털면 i번째 식량창고는 털지 못함
i-2번째 식량창고를 털면 i번째 식량창고를 털 수 있음
따라서, 점화식은 ai = maxOf(ai-1, ai-2 + ai) 이 된다
여기서 i-3번째 이하의 식량 창고에 대한 최적해는 고려하지 않는다
왜냐면 i-1과 i-2를 구하는 과정 자체에 이미 i-3번째에 대한 식량 창고를 고려했기 때문이다
 */