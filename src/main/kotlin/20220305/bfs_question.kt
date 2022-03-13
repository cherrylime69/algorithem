package `20220305`

import java.util.*

// 이것이 취업을 위한 코딩테스트다
// p.152 미로 탈출
// 자바 answer : https://github.com/ndb796/python-for-coding-test/blob/master/5/9.java
// 파이썬 answer : https://github.com/ndb796/python-for-coding-test/blob/master/5/11.py

fun main() {
    val (n, m) = readLine()!!.split(" ").map {it.toInt()}
    val map = Array(n+1) {IntArray(m)}

    for (i in 0 until n) {
        val s = readLine()!!
        for (j in 0 until m) {
            map[i][j] = s[j] - '0'
        }
    }

    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)

    fun bfs (_x: Int, _y: Int): Int {
        val q: Queue<Array<Int>> = LinkedList()
        q.offer(arrayOf(_x,_y))
        while (q.isNotEmpty()) {
            val (x, y) = q.poll()
            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue
                if (map[nx][ny] == 0 )
                    continue
                if (map[nx][ny] == 1) {
                    map[nx][ny] = map[x][y] + 1
                    q.offer(arrayOf(nx,ny))
                }
            }
        }
        return map[n-1][m-1]
    }

    print(bfs(0,0))
}
