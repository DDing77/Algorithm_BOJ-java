import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toInt()
        val map = Array(101) { BooleanArray(101) { false } }
        val dirs = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0),
            intArrayOf(0, 1)
        )

        val input = br.readLine()
        var minRow = 50
        var minCol = 50
        var maxRow = 50
        var maxCol = 50
        var curRow = 50
        var curCol = 50
        var curDirIdx = 0

        map[curRow][curCol] = true
        input.forEach { c ->
            run {
                when (c) {
                    'F' -> {
                        curRow += dirs[curDirIdx][0]
                        curCol += dirs[curDirIdx][1]
                        map[curRow][curCol] = true
                    }

                    'L' -> {
                        curDirIdx = (curDirIdx + 3) % 4
                    }

                    'R' -> {
                        curDirIdx = (curDirIdx + 1) % 4
                    }
                }
                minRow = min(minRow, curRow)
                minCol = min(minCol, curCol)
                maxRow = max(maxRow, curRow)
                maxCol = max(maxCol, curCol)
            }
        }

        val sb = StringBuilder()
        for (i in minRow..maxRow) {
            for (j in minCol..maxCol) {
                sb.append("${if (map[i][j]) '.' else '#'}")
            }
            sb.append("\n")
        }

        print(sb)
    }
}