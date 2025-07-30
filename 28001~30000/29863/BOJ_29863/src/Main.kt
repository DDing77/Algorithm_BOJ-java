import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val a = br.readLine().toInt()
        val b = br.readLine().toInt()

        when {
            a > b -> {
                print((b + 24) - a)
            }

            a <= b -> {
                print(b - a)
            }
        }
    }
}