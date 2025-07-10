import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { reader ->
        val k = reader.readLine().toInt()
        val weights = reader.readLine().split(" ").map { it.toInt() }
        val totalWeight = weights.sum()

        val reachable = BooleanArray(totalWeight + 1)

        dfs(0, 0, k, weights, reachable)

        val result = reachable.count { !it }

        println(result)
    }
}

fun dfs(index: Int, currentWeight: Int, k: Int, weights: List<Int>, reachable: BooleanArray) {
    if (index == k) {
        if (currentWeight >= 0 && currentWeight < reachable.size) {
            reachable[currentWeight] = true
        }
        return
    }

    dfs(index + 1, currentWeight, k, weights, reachable)
    dfs(index + 1, currentWeight + weights[index], k, weights, reachable)
    dfs(index + 1, currentWeight - weights[index], k, weights, reachable)
}
