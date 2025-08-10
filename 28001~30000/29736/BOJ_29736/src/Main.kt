import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (A, B) = br.readLine().split(" ").map { it.toInt() }
        val (K, X) = br.readLine().split(" ").map { it.toInt() }

        val left = K - X
        val right = K + X

        var res = 0
        for (i in A..B) {
            if (i in left..right) {
                res++
            }
        }

        when (res) {
            0 -> print("IMPOSSIBLE")
            else -> print("$res")
        }
    }
}