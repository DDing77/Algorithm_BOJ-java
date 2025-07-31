import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.round
import kotlin.math.sqrt

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toDouble()
        if (N <= 2) {
            print(4)
        } else {
            val sqrt = round(sqrt(N)).toInt()
            if (sqrt * sqrt >= N) {
                print((sqrt - 1) * 4)
            } else {
                print((sqrt * 2 + (sqrt - 1) * 2))
            }
        }
    }
}