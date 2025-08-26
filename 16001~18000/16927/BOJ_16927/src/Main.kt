import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.min

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, M, R) = br.readLine().split(" ").map { it.toInt() }
        val a = Array(N) { IntArray(M) }
        for (i in 0 until N) {
            val st = StringTokenizer(br.readLine())
            for (j in 0 until M) a[i][j] = st.nextToken().toInt()
        }

        val depth = min(N, M) / 2

        for (layer in 0 until depth) {
            val top = layer
            val left = layer
            val bottom = N - 1 - layer
            val right = M - 1 - layer

            val height = bottom - top
            val width  = right - left
            val L = 2 * (height + width)
            if (L == 0) continue

            val k = (R % L).toInt()

            val rr = IntArray(L)
            val cc = IntArray(L)
            var p = 0

            for (c in left until right) {
                rr[p] = top; cc[p] = c; p++
            }
            for (r in top until bottom) {
                rr[p] = r; cc[p] = right; p++
            }
            for (c in right downTo left + 1) {
                rr[p] = bottom; cc[p] = c; p++
            }
            for (r in bottom downTo top + 1) {
                rr[p] = r; cc[p] = left; p++
            }

            val vals = IntArray(L) { idx -> a[rr[idx]][cc[idx]] }

            for (i in 0 until L) {
                a[rr[i]][cc[i]] = vals[(i + k) % L]
            }
        }

        val sb = StringBuilder()
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (j > 0) sb.append(' ')
                sb.append(a[i][j])
            }
            sb.append('\n')
        }
        print(sb)
    }
}
