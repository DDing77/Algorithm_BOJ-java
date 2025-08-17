import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, M) = br.readLine().split(" ").map { it.toInt() } // N=행(입력의 M), M=열(입력의 N)
        val board = Array(N) { IntArray(M) }
        val isVisited = Array(N) { Array(M) { BooleanArray(4) } }

        for (i in 0 until N) {
            val st = StringTokenizer(br.readLine())
            for (j in 0 until M) {
                board[i][j] = st.nextToken().toInt()
            }
        }

        var (startX, startY, startDirIdx) = br.readLine().split(" ").map { it.toInt() }
        startX--; startY--; startDirIdx--

        var (endX, endY, endDirIdx) = br.readLine().split(" ").map { it.toInt() }
        endX--; endY--; endDirIdx--

        val dirs = arrayOf(
            intArrayOf(0, 1),   // 동
            intArrayOf(0, -1),  // 서
            intArrayOf(1, 0),   // 남
            intArrayOf(-1, 0)   // 북
        )

        val que = ArrayDeque<Robot>()
        que.add(Robot(startX, startY, startDirIdx, 0))
        isVisited[startX][startY][startDirIdx] = true

        var res = 0
        while (que.isNotEmpty()) {
            val cur = que.removeFirst()

            if (cur.x == endX && cur.y == endY && cur.dirIdx == endDirIdx) {
                res = cur.cnt
                break
            }

            // 전진 (Go 1..3)
            for (i in 1..3) {
                val nextX = cur.x + dirs[cur.dirIdx][0] * i
                val nextY = cur.y + dirs[cur.dirIdx][1] * i

                // 경계 밖이거나 벽을 만나면 그 이상 진행 불가
                if (nextX !in 0 until N || nextY !in 0 until M || board[nextX][nextY] == 1) {
                    break
                }

                // 방문 여부는 큐 삽입만 제어 (진행 시도는 계속)
                if (!isVisited[nextX][nextY][cur.dirIdx]) {
                    que.add(Robot(nextX, nextY, cur.dirIdx, cur.cnt + 1))
                    isVisited[nextX][nextY][cur.dirIdx] = true
                }
            }

            // 좌회전
            val nextLeftDirIdx = when (cur.dirIdx) {
                0 -> 3  // 동 -> 북
                1 -> 2  // 서 -> 남
                2 -> 0  // 남 -> 동
                else -> 1  // 북 -> 서
            }
            if (!isVisited[cur.x][cur.y][nextLeftDirIdx]) {
                que.add(Robot(cur.x, cur.y, nextLeftDirIdx, cur.cnt + 1))
                isVisited[cur.x][cur.y][nextLeftDirIdx] = true
            }

            // 우회전
            val nextRightDirIdx = when (cur.dirIdx) {
                0 -> 2  // 동 -> 남
                1 -> 3  // 서 -> 북
                2 -> 1  // 남 -> 서
                else -> 0  // 북 -> 동
            }
            if (!isVisited[cur.x][cur.y][nextRightDirIdx]) {
                que.add(Robot(cur.x, cur.y, nextRightDirIdx, cur.cnt + 1))
                isVisited[cur.x][cur.y][nextRightDirIdx] = true
            }
        }

        print(res)
    }
}

data class Robot(val x: Int, val y: Int, val dirIdx: Int, val cnt: Int)
