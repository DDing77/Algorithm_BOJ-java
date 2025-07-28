import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toInt()
        val sb = StringBuilder()
        for (i in 1..N / 5) {
            sb.append("V")
        }

        for (i in 1..N % 5) {
            sb.append("I")
        }

        print(sb)
    }
}