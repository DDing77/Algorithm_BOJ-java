import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        var time = 0
        repeat(4) {
            time += br.readLine()!!.toInt()
        }

        if (time <= 1500) {
            print("Yes")
        } else {
            print("No")
        }
    }
}