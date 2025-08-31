import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        val pq = PriorityQueue<Int> { o1, o2 -> o2 - o1 }

        var st = StringTokenizer(br.readLine())
        repeat(N) {
            pq.add(st.nextToken().toInt())
        }

        val kid = ArrayList<Int>()
        st = StringTokenizer(br.readLine())
        repeat(M) {
            kid.add(st.nextToken().toInt())
        }

        for (i in 0..<M) {
            var curBox = pq.poll()
            if (curBox < kid[i]) {
                print(0)
                return
            }

            curBox -= kid[i]
            if (curBox > 0) {
                pq.add(curBox)
            }
        }

        print(1)
    }
}