import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toInt()
        val zList = ArrayList<Int>()
        repeat(N) {
            zList.add(br.readLine().toInt())
        }

        zList.sort()

        var res = 0
        var count = 0

        for (z in zList) {
            count++
            if (count >= z + 1) {
                res += z + 1
                count = 0
            }
        }

        println(res)
    }
}
