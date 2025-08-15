import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, W) = br.readLine()!!.split(" ").map { it.toInt() }
        val edgeList = Array(N + 1) { ArrayList<Int>() }

        repeat(N - 1) {
            val (from, to) = br.readLine()!!.split(" ").map { it.toInt() }
            edgeList[from].add(to)
            edgeList[to].add(from)
        }

        var leafNodeCount = 0
        for (i in 2..N) {
            if (edgeList[i].size == 1) leafNodeCount++
        }

        print(String.format("%.10f", (W.toDouble() / leafNodeCount)))
    }
}