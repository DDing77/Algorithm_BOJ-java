import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().trim().toInt()

    var sum = 0
    var read = 0
    while (read < n) {
        val line = br.readLine() ?: break
        val st = StringTokenizer(line)
        while (st.hasMoreTokens() && read < n) {
            sum += st.nextToken().toInt()
            read++
        }
    }

    val result = when {
        sum > 0 -> "Right"
        sum < 0 -> "Left"
        else -> "Stay"
    }
    println(result)
}
