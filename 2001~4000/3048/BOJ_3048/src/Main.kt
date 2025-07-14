import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N1, N2) = br.readLine().split(" ").map { it.toInt() }
    val ant1 = br.readLine()
    val ant2 = br.readLine()
    val T = br.readLine().toInt()

    val state = mutableListOf<Pair<Char, Int>>()
    for (c in ant1.reversed()) {
        state.add(c to 1)
    }
    for (c in ant2) {
        state.add(c to 2)
    }

    repeat(T) {
        var i = 0
        while (i < state.size - 1) {
            if (state[i].second == 1 && state[i + 1].second == 2) {
                val tmp = state[i]
                state[i] = state[i + 1]
                state[i + 1] = tmp
                i += 2
            } else {
                i++
            }
        }
    }

    println(state.joinToString("") { it.first.toString() })
}
