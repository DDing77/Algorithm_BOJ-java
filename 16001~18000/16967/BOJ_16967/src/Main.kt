import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, M, X, Y) = br.readLine().split(" ").map { it.toInt() }
        val B = Array(N + X) { IntArray(M + Y) }

        for (i in 0..<N + X) {
            val st = StringTokenizer(br.readLine())
            for (j in 0..<M + Y) {
                B[i][j] = st.nextToken().toInt()
            }
        }

        val A = Array(N) { IntArray(M) }
        for (i in 0..<N) {
            for (j in 0..<M) {
                A[i][j] = B[i][j]
            }
        }

        for (i in X..<N) {
            for (j in Y..<M) {
                A[i][j] = B[i][j] - A[i - X][j - Y]
            }
        }

        val sb = StringBuilder()
        for (i in A.indices) {
            sb.append(A[i].joinToString(" ")).append("\n")
        }
        print(sb)
    }
}