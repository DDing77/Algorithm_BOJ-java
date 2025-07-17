import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        var N = br.readLine().toLong()

        var res = BigInteger.ZERO
        var v = BigInteger.ONE

        while (N > 0) {
            if ((N and 1L) == 1L) {
                res = res.add(v)
            }
            v = v.multiply(BigInteger.valueOf(3L))
            N = N shr 1
        }

        print(res)
    }
}