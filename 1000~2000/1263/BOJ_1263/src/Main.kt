import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.min

data class Work(val processTime: Int, val endTime: Int)

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val T = br.readLine().toInt()

        val works = Array<Work>(T) { i ->
            val st = StringTokenizer(br.readLine())
            Work(st.nextToken().toInt(), st.nextToken().toInt())
        }

        works.sortByDescending { it.endTime }
        var curTime = works[0].endTime

        for (i in 0..<works.size) {
            curTime = min(curTime, works[i].endTime) - works[i].processTime
            if (curTime < 0) {
                print(-1)
                return
            }
        }

        print(curTime)
    }
}