import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque

data class Status(val x: Int, val y: Int, val night: Boolean, val moveCount: Int, val crashCount: Int)

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, M, K) = br.readLine().split(" ").map { it.toInt() }
        val board = Array(N) { br.readLine().toCharArray() }

        val dirs = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(0, 0)
        )

        val visited = Array(N) { Array(M) { Array(2) { BooleanArray(K + 1) } } }

        val q = ArrayDeque<Status>()
        q.add(Status(0, 0, false, 1, 0))
        visited[0][0][0][0] = true

        fun inRange(x: Int, y: Int) = x in 0 until N && y in 0 until M

        while (q.isNotEmpty()) {
            val cur = q.removeFirst()

            if (cur.x == N - 1 && cur.y == M - 1) {
                println(cur.moveCount)
                return
            }

            for (d in dirs) {
                val nx = cur.x + d[0]
                val ny = cur.y + d[1]
                val nextNight = !cur.night
                val nightIdx = if (nextNight) 1 else 0

                if (d[0] == 0 && d[1] == 0) {
                    if (!visited[cur.x][cur.y][nightIdx][cur.crashCount]) {
                        visited[cur.x][cur.y][nightIdx][cur.crashCount] = true
                        q.add(Status(cur.x, cur.y, nextNight, cur.moveCount + 1, cur.crashCount))
                    }
                    continue
                }

                if (!inRange(nx, ny)) continue

                if (board[nx][ny] == '0') {
                    if (!visited[nx][ny][nightIdx][cur.crashCount]) {
                        visited[nx][ny][nightIdx][cur.crashCount] = true
                        q.add(Status(nx, ny, nextNight, cur.moveCount + 1, cur.crashCount))
                    }
                } else {
                    if (!cur.night && cur.crashCount < K) {
                        if (!visited[nx][ny][nightIdx][cur.crashCount + 1]) {
                            visited[nx][ny][nightIdx][cur.crashCount + 1] = true
                            q.add(Status(nx, ny, nextNight, cur.moveCount + 1, cur.crashCount + 1))
                        }
                    }
                }
            }
        }

        println(-1)
    }
}
