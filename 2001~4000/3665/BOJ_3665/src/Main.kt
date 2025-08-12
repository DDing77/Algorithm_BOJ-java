import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque
import java.util.StringTokenizer

private class FastScanner {
    private val br = BufferedReader(InputStreamReader(System.`in`))
    private var st: StringTokenizer? = null
    fun nextInt(): Int {
        while (st == null || !st!!.hasMoreTokens()) {
            st = StringTokenizer(br.readLine())
        }
        return st!!.nextToken().toInt()
    }
}

fun main() {
    val fs = FastScanner()
    val t = fs.nextInt()

    val out = buildString {
        repeat(t) {
            appendLine(solveCase(fs))
        }
    }
    print(out)
}

private fun solveCase(fs: FastScanner): String {
    val n = fs.nextInt()
    val rank = IntArray(n) { fs.nextInt() }

    val adj = Array(n + 1) { BooleanArray(n + 1) }
    val indeg = IntArray(n + 1)

    for (i in 0 until n) {
        val u = rank[i]
        for (j in i + 1 until n) {
            val v = rank[j]
            if (!adj[u][v]) {
                adj[u][v] = true
                indeg[v]++
            }
        }
    }

    fun reverseEdge(a: Int, b: Int) {
        if (adj[a][b]) {
            adj[a][b] = false
            indeg[b]--
            if (!adj[b][a]) {
                adj[b][a] = true
                indeg[a]++
            }
        } else {
            if (adj[b][a]) {
                adj[b][a] = false
                indeg[a]--
            }
            if (!adj[a][b]) {
                adj[a][b] = true
                indeg[b]++
            }
        }
    }

    repeat(fs.nextInt()) {
        val a = fs.nextInt()
        val b = fs.nextInt()
        reverseEdge(a, b)
    }

    val q = ArrayDeque<Int>().apply {
        for (v in 1..n) if (indeg[v] == 0) add(v)
    }

    val result = IntArray(n)
    var idx = 0
    var ambiguous = false
    var impossible = false

    repeat(n) {
        if (q.isEmpty()) {
            impossible = true
            return@repeat
        }
        if (q.size > 1) ambiguous = true

        val u = q.removeFirst()
        result[idx++] = u

        for (v in 1..n) {
            if (adj[u][v]) {
                adj[u][v] = false
                if (--indeg[v] == 0) q.add(v)
            }
        }
    }

    return when {
        impossible -> "IMPOSSIBLE"
        ambiguous -> "?"
        else -> result.joinToString(" ")
    }
}
