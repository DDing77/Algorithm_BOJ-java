import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val edges = Array(13) { ArrayList<Int>() }
        repeat(12) {
            val (from, to) = br.readLine().split(" ").map { it.toInt() }
            edges[from].add(to)
            edges[to].add(from)
        }

        for (i in 1..12) {
            val check = BooleanArray(4)

            if (edges[i].size == 3) {
                for (next in edges[i]) {
                    check[edges[next].size] = true
                }
                if (check[1] && check[2] && check[3]) {
                    print(i)
                    return
                }
            }
        }
    }
}