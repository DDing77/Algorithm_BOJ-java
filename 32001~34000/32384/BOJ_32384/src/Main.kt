import java.io.*

fun main() = BufferedReader(InputStreamReader(System.`in`)).run {
    val sb: StringBuilder = StringBuilder()

    val N: Int = readLine().toInt()
    val word: String = "LoveisKoreaUniversity"

    repeat(N - 1) {
        sb.append(word).append(" ")
    }
    sb.append(word)
    print(sb)
}