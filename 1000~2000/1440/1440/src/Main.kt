import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = BufferedReader(InputStreamReader(System.`in`)).use { br ->
    val s = br.readLine().trim()
    val v = s.split(":").map { it.toInt() }

    fun isHour(x: Int) = x in 1..12
    fun isMinSec(x: Int) = x in 0..59

    val okH = BooleanArray(3) { isHour(v[it]) }
    val okMS = BooleanArray(3) { isMinSec(v[it]) }

    var ans = 0
    for (i in 0 until 3) {
        if (!okH[i]) continue
        val a = (i + 1) % 3
        val b = (i + 2) % 3
        if (okMS[a] && okMS[b]) ans += 2
    }

    println(ans)
}
