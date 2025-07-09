import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = BufferedReader(InputStreamReader(System.`in`)).run {
    val word: String = readLine()
    val sb = StringBuilder()

    var zeroCnt: Int = word.count { it == '0' } / 2
    var oneCnt: Int = word.count { it == '1' } / 2

    for (c in word) {
        if (c == '0' && zeroCnt > 0 || c == '1' && oneCnt <= 0) {
            sb.append(c)
        }

        when (c) {
            '0' -> zeroCnt--
            '1' -> oneCnt--
        }
    }

    print(sb)
}