import java.io.*

fun main() = BufferedReader(InputStreamReader(System.`in`)).run {
    val word: String = readLine()
    var n: Int = 1

    var idx: Int = 0
    while (true) {
        for (c in n.toString().toCharArray()) {
            if (c == word[idx]) {
                idx++
            }
            if (idx == word.length) {
                println(n)
                return
            }
        }
        n++
    }
}