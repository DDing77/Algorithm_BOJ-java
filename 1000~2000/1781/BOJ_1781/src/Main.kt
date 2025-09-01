import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toInt()
        val deadLineMap = HashMap<Int, ArrayList<Int>>()

        repeat(N) {
            val (deadLine, reward) = br.readLine().split(" ").map { it.toInt() }
            deadLineMap.computeIfAbsent(deadLine) { ArrayList() }.add(reward)
        }

        val sortedKeys = deadLineMap.keys.sorted()
        val pq = PriorityQueue<Int>()

        for (deadLine in sortedKeys) {
            for (reward in deadLineMap.get(deadLine)!!) {
                pq.add(reward)
                if (pq.size > deadLine) pq.poll()
            }
        }

        var res = 0
        while (pq.isNotEmpty()) {
            res += pq.poll()
        }

        print(res)
    }
}