import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        var (N, K) = br.readLine().split(" ").map { it.toLong() }
        var cur = 0L
        var numLength = 1L
        var numCount = 9L

        while (K > numLength * numCount) {
            K -= numLength * numCount
            cur += numCount
            numCount *= 10
            numLength++
        }

        cur = (cur + 1) + (K - 1) / numLength

        if (cur > N) {
            print(-1)
        } else {
            print(cur.toString()[((K - 1) % numLength).toInt()])
        }
    }
}