import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, K) = br.readLine().split(' ').map { it.toInt() }

        var maxTime = -1

        repeat(N) {
            val (s, t) = br.readLine().split(' ').map { it.toInt() }
            if (s + t <= K) {
                maxTime = Math.max(maxTime, s)
            }
        }

        print(maxTime)
    }
}