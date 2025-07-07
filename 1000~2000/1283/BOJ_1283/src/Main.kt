import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = BufferedReader(InputStreamReader(System.`in`)).use { reader ->
    val n = reader.readLine().toInt()
    val used = mutableSetOf<Char>()
    val resSb = StringBuilder()

    repeat(n) {
        val line = reader.readLine()
        val words = line.split(" ")

        val result = buildString {
            val firstUnusedWordIndex = words.indexOfFirst { word ->
                word.first().lowercaseChar() !in used
            }

            if (firstUnusedWordIndex >= 0) {
                val chosenChar = words[firstUnusedWordIndex].first().lowercaseChar()
                used.add(chosenChar)

                append(
                    words.mapIndexed { i, word ->
                        if (i == firstUnusedWordIndex) {
                            "[${word[0]}]${word.substring(1)}"
                        } else {
                            word
                        }
                    }.joinToString(" ")
                )
                return@buildString
            }

            val firstUnusedCharIndex = line.indexOfFirst { c ->
                c != ' ' && c.lowercaseChar() !in used
            }

            if (firstUnusedCharIndex >= 0) {
                val chosenChar = line[firstUnusedCharIndex].lowercaseChar()
                used.add(chosenChar)

                append(line.substring(0, firstUnusedCharIndex))
                append("[${line[firstUnusedCharIndex]}]")
                append(line.substring(firstUnusedCharIndex + 1))
            } else {
                append(line)
            }
        }

        resSb.append(result).append("\n")
    }
    print(resSb)
}
