import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

data class Task(val d: Int, val t: Int)

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toInt()

        val pq = PriorityQueue(compareByDescending(Task::t))
        repeat(N) {
            val (d, t) = br.readLine().split(" ").map { it.toInt() }
            pq.add(Task(d, t))
        }

        var curTime = pq.peek().t
        while (pq.isNotEmpty()) {
            val task = pq.poll()
            if (curTime > task.t) {
                curTime = task.t
            }
            curTime -= task.d
        }

        print(curTime)
    }
}