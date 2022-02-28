package `20220227`

// 이것이 취업을 위한 코딩테스트다
// p.149 음료수 얼려 먹기

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val graph = Array(n) { IntArray(m) }

    (0 until n).forEach { n ->
        val s = readLine()!!
        (0 until m).forEach { m ->
            graph[n][m] = s[m] - '0'
        }
    }


    fun dfs(x: Int, y: Int): Boolean {
        if (x <= -1 || x >= n || y <= -1 || y >= m)
            return false
        if (graph[x][y] == 0) {
            graph[x][y] = 1
            dfs(x - 1, y)
            dfs(x + 1, y)
            dfs(x, y - 1)
            dfs(x, y + 1)
            return true
        }
        return false
    }


    var result = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (dfs(i, j)) {
                graph[i][j]
                result++
            }

        }
    }
    println(result)
}









