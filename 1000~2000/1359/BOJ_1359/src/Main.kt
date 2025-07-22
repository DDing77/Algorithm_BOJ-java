import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (N, M, K) = br.readLine().split(" ").map { it.toInt() }
        val fact = LongArray(11) {1L}
        for (i in 1..10) {
            fact[i] = fact[i - 1] * i
        }

        fun comb(n: Int, r: Int): Long {
            if (r <0 || r > n) {
                return 0L;
            }
            return fact[n] / (fact[r] * fact[n - r])
        }

        val total = comb(N, M).toDouble()
        var winCase = 0.0

        for (i in K..M) {
            val choose = comb(M, i)
            val notChoose = comb(N - M, M - i)
            winCase += choose * notChoose
        }

        print(winCase / total)
    }
}