import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    while (true) {
        val line = br.readLine()
        val earthWeight = line.toDouble()

        if (earthWeight < 0) {
            break
        }

        val moonWeight = earthWeight * 0.167

        sb.append(
            "Objects weighing %.2f on Earth will weigh %.2f on the moon."
                .format(earthWeight, moonWeight)
        ).append("\n")
    }

    print(sb)
}
