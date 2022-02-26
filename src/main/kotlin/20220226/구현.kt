package `20220226`

fun main() {
    val map = readLine()!!.split(" ")
    val loc = readLine()!!.split(" ").map { it -> it.toInt() }
    val maplist = ArrayList<MutableList<Int>>()
    (1..map[0].toInt()).forEach { _ ->
        maplist.add(readLine()!!.split(" ").map { it -> it.toInt() }.toMutableList())
    }

    maplist.forEach {
        println(it.toString())
    }

    var nextX = loc[0]
    var nextY = loc[1]
    var count = 0
    var tried = 0

    var d = loc[2]

    val dx = arrayOf(-1, 0, 1, 0)
    val dy = arrayOf(0, 1, 0, -1)

    while (true) {
        var i = d % 4
        if (tried < 4) {
            if (maplist[nextX + dx[i]][nextY + dy[i]] > 0) {
                tried++
                if (tried < 4)
                    d++
                continue
            } else {
                maplist[nextX][nextY] = 2
                nextX += dx[i]
                nextY += dy[i]
                count++
                tried = 0
            }
        } else {
            i = (d + 2) % 4
            if (maplist[nextX + dx[i]][nextY + dy[i]] == 1) {
                count += 1
                break
            } else {
                maplist[nextX][nextY] = 2
                nextX += dx[i]
                nextY += dy[i]
                count++
                tried = 0
                continue
            }
        }
    }
    println(count)
}