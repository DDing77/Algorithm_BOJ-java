import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, K) = br.readLine().split(" ").map { it.toInt() }

        val que = ArrayDeque<Char>()
        repeat(N) {
            que.add('?')
        }

        repeat(K) {
            val (S, C) = br.readLine().split(" ")
            val time = S.toInt() - 1
            repeat(time) {
                que.addLast(que.removeFirst())
            }

            val cur = que.removeFirst()
            if (cur == '?' || cur == C[0]) {
                que.addLast(C[0])
            } else if (cur != C[0]) {
                print("!")
                return
            }
        }

        val sb = StringBuilder()
        val set = HashSet<Char>()
        while (que.isNotEmpty()) {
            val cur = que.removeLast()
            if (cur != '?') {
                if (set.contains(cur)) {
                    print("!")
                    return
                }
            }
            sb.append(cur)
            set.add(cur)
        }
        print(sb)
    }
}