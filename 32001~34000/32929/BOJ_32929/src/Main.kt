import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toInt()
        val idx = (N - 1) % 3
        val word = "UOS"
        print(word[idx])
    }
}