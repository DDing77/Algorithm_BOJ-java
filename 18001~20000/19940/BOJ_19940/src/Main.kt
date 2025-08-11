import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

private const val SIXTY = 60
private const val TEN = 10

private fun computeButtons(n: Int): IntArray {
    var sixties = n / SIXTY
    var tens = (n % SIXTY) / TEN
    var ones = n % TEN

    if (ones > 5) {
        tens += 1
        ones -= 10
    }
    if (tens > 3) {
        sixties += 1
        tens -= 6
    }
    if (tens < 0 && ones == 5) {
        tens += 1
        ones -= 10
    }

    return intArrayOf(
        sixties,
        if (tens >= 0) tens else 0,
        if (tens < 0) abs(tens) else 0,
        if (ones >= 0) ones else 0,
        if (ones < 0) abs(ones) else 0
    )
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().trim().toInt()

    val out = buildString {
        repeat(t) {
            val n = br.readLine().trim().toInt()
            append(computeButtons(n).joinToString(" "))
            append('\n')
        }
    }
    print(out)
}
