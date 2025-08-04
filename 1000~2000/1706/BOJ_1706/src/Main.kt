import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (R, C) = br.readLine().split(" ").map { it.toInt() }

        val board = Array(R, { CharArray(C) })
        for (i in 0..<R) {
            board[i] = br.readLine().toCharArray()
        }

        val list = mutableListOf<String>()
        for (i in 0..<R) {
            val rowWords = board[i].joinToString("").split("#")
            for (rowWord in rowWords) {
                if (rowWord.length > 1) {
                    list.add(rowWord)
                }
            }
        }

        for (j in 0..<C) {
            var tempWord = ""
            for (i in 0..<R) {
                tempWord = tempWord.plus(board[i][j])
            }
            val colWords = tempWord.split("#")
            for (colWord in colWords) {
                if (colWord.length > 1) {
                    list.add(colWord)
                }
            }
        }

        list.sort()

        print(list[0])
    }
}