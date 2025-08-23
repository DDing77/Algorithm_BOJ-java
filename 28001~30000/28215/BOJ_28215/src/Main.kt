import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val K = st.nextToken().toInt()

    val xs = IntArray(N)
    val ys = IntArray(N)
    repeat(N) { i ->
        st = StringTokenizer(br.readLine())
        xs[i] = st.nextToken().toInt()
        ys[i] = st.nextToken().toInt()
    }

    val dist = Array(N) { IntArray(N) }
    for (i in 0 until N) {
        for (j in 0 until N) {
            dist[i][j] = abs(xs[i] - xs[j]) + abs(ys[i] - ys[j])
        }
    }

    val picked = IntArray(K)
    var answer = Int.MAX_VALUE

    fun evaluate(): Int {
        var comboCost = 0
        for (j in 0 until N) {
            var close = Int.MAX_VALUE
            for (t in 0 until K) {
                close = min(close, dist[j][picked[t]])
            }
            comboCost = max(comboCost, close)
        }
        return comboCost
    }

    fun dfs(depth: Int, start: Int) {
        if (depth == K) {
            answer = min(answer, evaluate())
            return
        }
        val limit = N - (K - depth) + 1
        for (i in start until limit) {
            picked[depth] = i
            dfs(depth + 1, i + 1)
        }
    }

    dfs(0, 0)
    println(answer)
}
