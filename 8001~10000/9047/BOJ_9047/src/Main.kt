import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val T = br.readLine().toInt()
        val sb = StringBuilder()

        repeat(T) {
            var number = br.readLine().toInt()
            var count = 0
            while (number != 6174) {
                val numArr = IntArray(4)
                for (i in 0 until 4) {
                    numArr[i] = number % 10
                    number /= 10
                }

                numArr.sort()

                var maxNum = 0
                var minNum = 0
                for (i in numArr.indices) {
                    maxNum = maxNum * 10 + numArr[3 - i]
                    minNum = minNum * 10 + numArr[i]
                }

                count++
                number = maxNum - minNum
            }

            sb.append(count).append("\n")
        }
        print(sb)
    }
}