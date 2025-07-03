import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = BufferedReader(InputStreamReader(System.`in`)).run {

    val words = readLine()
    var aTotalCnt = 0
    for (c in words) {
        if (c == 'a') {
            aTotalCnt++
        }
    }

    var bMinCnt = words.length
    for (i in words.indices) {
        var bCnt = 0
        for (j in 0 until aTotalCnt) {
            var curIdx = i + j
            if (i + j >= words.length) {
                curIdx -= words.length
            }
            if (words.get(curIdx) == 'b') {
                bCnt++
            }
        }
        bMinCnt = min(bCnt, bMinCnt)
    }

    print(bMinCnt)
}