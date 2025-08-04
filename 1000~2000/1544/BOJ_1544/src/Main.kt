import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->

        fun ArrayDeque<Char>.rotate() {
            val front = this.removeFirst()
            this.addLast(front)
        }

        fun check(word1: String, word2: String): String {
            if (word1.length != word2.length) return word2
            val dq = ArrayDeque<Char>(word2.toList())

            for (i in word2.indices) {
                dq.rotate()
                val tempWord2 = dq.joinToString("")
                if (word1 == tempWord2) return word1
            }

            return dq.joinToString("")
        }

        val N = br.readLine().toInt()
        val wordList = mutableListOf<String>()
        repeat(N) {
            wordList.add(br.readLine())
        }

        for (i in wordList.indices) {
            for (j in i..<wordList. size) {
                if (wordList[i] != wordList[j]) {
                    wordList[j] = check(wordList[i], wordList[j])
                }
            }
        }

        val set = mutableSetOf<String>()
        for (s in wordList) {
            set.add(s)
        }

        print(set.size)

    }
}