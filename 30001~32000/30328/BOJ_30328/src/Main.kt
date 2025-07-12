import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val n = br.readLine().toInt()
        print("${n * 4000}")
    }
}