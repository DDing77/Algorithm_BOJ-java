import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val board = Array(5) { CharArray(9) }
        // 헥사그램 12칸의 좌표를 입력 스캔 순서(사전순 비교와 동일)로 기록
        val pos = Array(12) { IntArray(2) }

        var idx = 0
        val numbers = IntArray(12)        // 각 자리(0..11)에 놓인 숫자(1..12), 0이면 미배치
        val fixed = BooleanArray(12)      // 초기 고정 여부
        val used = BooleanArray(13)       // 숫자 1..12 사용 여부

        for (i in 0 until 5) {
            val line = br.readLine()
            for (j in 0 until 9) {
                board[i][j] = line[j]
                if (board[i][j] == 'x' || board[i][j] in 'A'..'L') {
                    pos[idx][0] = i
                    pos[idx][1] = j
                    if (board[i][j] in 'A'..'L') {
                        val v = board[i][j] - 'A' + 1
                        numbers[idx] = v
                        fixed[idx] = true
                        used[v] = true
                    }
                    idx++
                }
            }
        }

        val lines = arrayOf(
            intArrayOf(0, 2, 5, 7),
            intArrayOf(0, 3, 6, 10),
            intArrayOf(1, 2, 3, 4),
            intArrayOf(1, 5, 8, 11),
            intArrayOf(4, 6, 9, 11),
            intArrayOf(7, 8, 9, 10)
        )

        fun partialValid(afterPlacedIdx: Int): Boolean {
            for (line in lines) {
                if (line.contains(afterPlacedIdx)) {
                    var sum = 0
                    var cnt = 0
                    for (p in line) {
                        if (numbers[p] != 0) {
                            sum += numbers[p]
                            cnt++
                        }
                    }
                    // 부분합이 26을 넘으면 불가능
                    if (sum > 26) return false
                    // 4개가 모두 채워졌으면 정확히 26이어야 함
                    if (cnt == 4 && sum != 26) return false
                    // 4개가 안 채워졌는데 이미 26이 되면 이후 양수 추가로 26 초과 → 불가능
                    if (cnt < 4 && sum == 26) return false
                }
            }
            return true
        }

        fun checkAll26(): Boolean {
            for (line in lines) {
                var s = 0
                for (p in line) s += numbers[p]
                if (s != 26) return false
            }
            return true
        }

        var done = false

        fun execDFS(depth: Int) {
            if (done) return
            if (depth == 12) {
                if (checkAll26()) {
                    for (i in 0 until 12) {
                        val (r, c) = pos[i]
                        board[r][c] = ('A'.code + numbers[i] - 1).toChar()
                    }
                    val sb = StringBuilder()
                    for (i in 0 until 5) {
                        sb.append(board[i].concatToString()).append('\n')
                    }
                    print(sb.toString())
                    done = true
                }
                return
            }

            if (fixed[depth]) {
                if (partialValid(depth)) execDFS(depth + 1)
                return
            }

            for (v in 1..12) {
                if (used[v]) continue
                numbers[depth] = v
                if (partialValid(depth)) {
                    used[v] = true
                    execDFS(depth + 1)
                    used[v] = false
                }
                numbers[depth] = 0
                if (done) return
            }
        }

        execDFS(0)
    }
}
