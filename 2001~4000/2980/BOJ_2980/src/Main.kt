import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, L) = br.readLine().split(" ").map { it.toInt() }

        var time = 0
        var dist = 0

        repeat(N) {
            val (D, R, G) = br.readLine().split(" ").map { it.toInt() }
            time += D - dist
            dist = D

            val timeGap = time % (R + G)
            if (timeGap < R) {
                time += R - timeGap
            }
        }

        time += L - dist

        print(time)
    }
}