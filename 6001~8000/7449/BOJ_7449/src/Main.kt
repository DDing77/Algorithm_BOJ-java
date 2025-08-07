import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val adj = MutableList(N) { mutableListOf<Int>() }

    repeat(N) {
        val tokens = br.readLine().split(" ").map { it.toInt() }
        val from = tokens[0]
        val friends = tokens.drop(2)
        for (to in friends) {
            adj[from].add(to)
            adj[to].add(from)
        }
    }

    val (c1, c2) = br.readLine().split(" ").map { it.toInt() }

    val distance = bfs(c1, c2, adj)
    println("$c1 $c2 ${distance - 1}")
}

fun bfs(start: Int, end: Int, adj: List<List<Int>>): Int {
    val visited = BooleanArray(adj.size)
    val dist = IntArray(adj.size) { -1 }

    val queue: Queue<Int> = LinkedList()
    queue.add(start)
    visited[start] = true
    dist[start] = 0

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        for (next in adj[cur]) {
            if (!visited[next]) {
                visited[next] = true
                dist[next] = dist[cur] + 1
                if (next == end) return dist[next]
                queue.add(next)
            }
        }
    }
    return dist[end]
}
