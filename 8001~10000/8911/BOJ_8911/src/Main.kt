import java.io.*;
import kotlin.math.max
import kotlin.math.min

fun main() = System.`in`.bufferedReader().run {
    val sb: StringBuilder = StringBuilder()

    val dirs = arrayOf(
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(0, -1)
    )

    repeat (readLine().toInt()) {
        var curX: Int = 0;
        var curY: Int = 0;
        var minX: Int = 0;
        var minY: Int = 0;
        var maxX: Int = 0;
        var maxY: Int = 0;
        var curDir: Int = 0;

        var op: CharArray = readLine().toCharArray()

        for (c: Char in op) {
            if (c == 'F') {
                curX += dirs[curDir][0]
                curY += dirs[curDir][1]
            } else if (c == 'B') {
                var tempDir: Int = (curDir + 2) % dirs.size
                curX += dirs[tempDir][0]
                curY += dirs[tempDir][1]
            } else if (c == 'L') {
                curDir = (curDir + dirs.size - 1) % dirs.size
            } else if (c == 'R') {
                curDir = (curDir + 1) % dirs.size
            }

            minX = min(minX, curX)
            minY = min(minY, curY)
            maxX = max(maxX, curX)
            maxY = max(maxY, curY)
        }

        var s = (maxX - minX) * (maxY - minY)
        sb.append(s).append("\n")
    }
    print(sb)
}