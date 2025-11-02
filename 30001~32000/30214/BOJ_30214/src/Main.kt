import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (s1, s2) = br.readLine().split(" ").map { it.toDouble() }
        if (s2 / 2 <= s1) {
            print("E")
        } else {
            print("H")
        }
    }
}