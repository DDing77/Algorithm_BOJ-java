import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.min

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, M, R) = br.readLine().split(" ").map { it.toInt() }

        val board = Array(N) { IntArray(M) }
        val depth = min(N, M) / 2

        for (i in 0..<N) {
            val st = StringTokenizer(br.readLine())
            for (j in 0..<M) {
                board[i][j] = st.nextToken().toInt()
            }
        }

        var rowEnd = N
        var colEnd = M
        var rowWidth = N
        var colWidth = M
        for (i in 0..<depth) {
            val repeatCount = R % (rowWidth * 2 + colWidth * 2 - 4)
            repeat(repeatCount) {
                val temp = board[i][i]
                // 상단
                for (j in i..<colEnd - 1) {
                    board[i][j] = board[i][j + 1]
                }
                // 우측
                for (j in i..<rowEnd - 1) {
                    board[j][colEnd - 1] = board[j + 1][colEnd - 1]
                }
                // 하단
                for (j in (colEnd - 1) downTo i + 1)
                    board[rowEnd - 1][j] = board[rowEnd - 1][j - 1]
                // 좌측
                for (j in rowEnd - 1 downTo i + 1) {
                    board[j][i] = board[j - 1][i]
                }
                board[i + 1][i] = temp
            }
            rowEnd--
            colEnd--
            rowWidth -= 2
            colWidth -= 2
        }

        val sb = StringBuilder()
        for (arr in board) {
            sb.append(arr.joinToString(" ")).append("\n")
        }
        print(sb)
    }
}