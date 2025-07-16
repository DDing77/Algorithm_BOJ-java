import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val sb = StringBuilder()

        val isNotPrimes = BooleanArray(1001)
        val primeList = mutableListOf<Int>()

        for (i in 2..1000) {
            if (!isNotPrimes[i]) {
                primeList.add(i)
                for (j in i * 2..1000 step i) {
                    isNotPrimes[j] = true
                }
            }
        }

        val T = br.readLine().toInt()
        repeat(T) {
            val K = br.readLine().toInt()
            var flag = false
            outer@ for (i in 0 until primeList.size) {
                for (j in i until primeList.size) {
                    for (k in j until primeList.size) {
                        if (primeList[i] + primeList[j] + primeList[k] == K) {
                            flag = true
                            sb.append("${primeList[i]} ${primeList[j]} ${primeList[k]}").append("\n")
                            break@outer
                        }
                    }
                }
            }

            if (!flag) {
                sb.append(0).append("\n")
            }
        }

        print(sb)
    }
}