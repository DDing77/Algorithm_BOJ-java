import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.reflect.typeOf

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val left = HashMap<Char, Pair<Int, Int>>()
        left.put('q', Pair(0, 0))
        left.put('a', Pair(1, 0))
        left.put('z', Pair(2, 0))

        left.put('w', Pair(0, 1))
        left.put('s', Pair(1, 1))
        left.put('x', Pair(2, 1))

        left.put('e', Pair(0, 2))
        left.put('d', Pair(1, 2))
        left.put('c', Pair(2, 2))

        left.put('r', Pair(0, 3))
        left.put('f', Pair(1, 3))
        left.put('v', Pair(2, 3))

        left.put('t', Pair(0, 4))
        left.put('g', Pair(1, 4))

        val right = HashMap<Char, Pair<Int, Int>>()
        right.put('b', Pair(2, 4))
        right.put('y', Pair(0, 5))
        right.put('h', Pair(1, 5))
        right.put('n', Pair(2, 5))
        right.put('u', Pair(0, 6))
        right.put('j', Pair(1, 6))
        right.put('m', Pair(2, 6))
        right.put('i', Pair(0, 7))
        right.put('k', Pair(1, 7))
        right.put('o', Pair(0, 8))
        right.put('l', Pair(1, 8))
        right.put('p', Pair(0, 9))

        val input = br.readLine()
        var lc = input[0]
        var rc = input[2]

        val word = br.readLine()

        var res = 0
        for (c in word) {
            if (left.containsKey(c)) {
                res += Math.abs(left[c]!!.first - left[lc]!!.first)
                res += Math.abs(left[c]!!.second - left[lc]!!.second)
                lc = c
            } else {
                res += Math.abs(right[c]!!.first - right[rc]!!.first)
                res += Math.abs(right[c]!!.second - right[rc]!!.second)
                rc = c
            }
            res++
        }
        print(res)
    }
}
