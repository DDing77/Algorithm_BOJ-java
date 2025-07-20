import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (t1, t2) = br.readLine().split(" ").map { it.toInt() }
        print(Math.min(t1, t2))
    }
}