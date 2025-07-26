import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val T = br.readLine().toInt()
        val sb = StringBuilder()

        repeat(T) {
            val N = br.readLine().toLong()

            val que = ArrayDeque<Long>()
            val set = setOf<Long>()
            set.plus(1L)
            que.add(1L)

            while (que.isNotEmpty()) {
                val cur = que.removeFirst()
                if (cur % N == 0L) {
                    sb.append(cur).append("\n")
                    break
                }

                if (!set.contains(cur * 10)) {
                    que.add(cur * 10)
                    set.plus(cur * 10)
                }

                if (!set.contains(cur * 10 + 1)) {
                    que.add(cur * 10 + 1)
                    set.plus(cur * 10 + 1)
                }
            }
        }

        print(sb)
    }
}