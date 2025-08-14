import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val S = br.readLine().toInt()
        val F = br.readLine().toInt()

        if (S > F) {
            println("flight")
        } else {
            println("high speed rail")
        }
    }
}