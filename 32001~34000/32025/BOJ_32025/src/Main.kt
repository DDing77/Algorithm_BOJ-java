import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val H = br.readLine().toInt()
        val W = br.readLine().toInt()

        print(Math.min(H, W) * 50)
    }
}