import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toInt()
        val VList = br.readLine().split(" ").map { it.toLong() }

        var cur = 1L
        var res = 1L
        for (i in N - 2 downTo 0) {
            when {
                VList[i] > cur -> {
                    cur += 1
                }

                VList[i] < cur -> {
                    cur = VList[i]
                }
            }
            res += cur
        }

        print(res)
    }
}