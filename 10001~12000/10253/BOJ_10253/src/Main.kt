import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val T = br.readLine().toInt()
        val sb = StringBuilder()

        fun getGCD(a: Int, b: Int): Int {
            if (b == 0) return a
            return getGCD(b, a % b)
        }

        repeat(T) {
            var (a, b) = br.readLine().split(" ").map { it.toInt() }

            while (a != 1) {
                val x = (b + (a - 1)) / a
                a = a * x - b
                b *= x

                val gcd = getGCD(a, b)
                a /= gcd
                b /= gcd
            }
            sb.append(b).append("\n")
        }

        print(sb)
    }
}