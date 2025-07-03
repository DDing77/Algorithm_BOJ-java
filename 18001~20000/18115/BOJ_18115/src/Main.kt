import java.io.*
import java.util.ArrayDeque
import java.util.Deque
import java.util.StringTokenizer

fun main() = BufferedReader(InputStreamReader(System.`in`)).run {
    val st: StringTokenizer
    val sb: StringBuilder = StringBuilder()

    val N: Int = readLine().toInt()

    st = StringTokenizer(readLine())
    val nums: IntArray = IntArray(N)
    for (i in N - 1 downTo 0) {
        nums[i] = st.nextToken().toInt()
    }

    val dq: Deque<Int> = ArrayDeque()
    for (i in 0 until N) {
        when (nums[i]) {
            1 -> dq.addFirst(i + 1)
            2 -> {
                var temp = dq.removeFirst()
                dq.addFirst(i + 1)
                dq.addFirst(temp)
            }

            3 -> dq.addLast(i + 1)
        }
    }

    while (!dq.isEmpty()) {
        sb.append(dq.removeFirst()).append(" ")
    }
    print(sb)
}