import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque

data class State(val ax: Int, val ay: Int, val bx: Int, val by: Int, val depth: Int)

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        val board = Array(N) { CharArray(M) }
        val coins = ArrayList<Pair<Int, Int>>(2)

        for (i in 0 until N) {
            val line = br.readLine()
            for (j in 0 until M) {
                var c = line[j]
                if (c == 'o') {
                    coins.add(i to j)
                    c = '.'
                }
                board[i][j] = c
            }
        }

        val dirs = arrayOf(
            intArrayOf(-1, 0),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(0, 1)
        )

        val visited = Array(N) { Array(M) { Array(N) { BooleanArray(M) } } }

        val q = ArrayDeque<State>()
        val (a0x, a0y) = coins[0]
        val (b0x, b0y) = coins[1]
        q.add(State(a0x, a0y, b0x, b0y, 0))
        visited[a0x][a0y][b0x][b0y] = true

        fun outOfBounds(x: Int, y: Int) = x !in 0 until N || y !in 0 until M

        while (q.isNotEmpty()) {
            val cur = q.removeFirst()

            if (cur.depth >= 10) continue

            for (d in dirs) {
                var nax = cur.ax + d[0]
                var nay = cur.ay + d[1]
                var nbx = cur.bx + d[0]
                var nby = cur.by + d[1]

                val aFall = outOfBounds(nax, nay)
                val bFall = outOfBounds(nbx, nby)

                // 두 개 다 떨어지면 무효
                if (aFall && bFall) continue

                // 정확히 하나만 떨어지면 정답
                if (aFall xor bFall) {
                    println(cur.depth + 1)
                    return
                }

                if (board[nax][nay] == '#') {
                    nax = cur.ax
                    nay = cur.ay
                }
                if (board[nbx][nby] == '#') {
                    nbx = cur.bx
                    nby = cur.by
                }

                if (!visited[nax][nay][nbx][nby]) {
                    visited[nax][nay][nbx][nby] = true
                    q.add(State(nax, nay, nbx, nby, cur.depth + 1))
                }
            }
        }

        println(-1)
    }
}
