import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toInt()
        val infos = ArrayList<Info>()

        repeat(N) {
            val (price, delivery) = br.readLine().split(" ").map { it.toInt() }
            infos.add(Info(price, delivery))
        }

        var maxProfit = 0
        var bestPrice = 0

        val priceCandidates = infos.map { it.price }.toSet()

        for (price in priceCandidates) {
            var sum = 0
            for ((p, d) in infos) {
                if (p >= price) {
                    val profit = price - d
                    if (profit > 0) {
                        sum += profit
                    }
                }
            }

            if (sum > maxProfit || (sum == maxProfit && price < bestPrice)) {
                maxProfit = sum
                bestPrice = price
            }
        }

        println(if (maxProfit > 0) bestPrice else 0)
    }
}

data class Info(val price: Int, val delivery: Int)
