import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val N = br.readLine().toInt()
        val words = mutableListOf<String>()

        repeat(N) {
            words.add(br.readLine())
        }

        var res = 0
        for (i in 0..words.size - 2) {
            for (j in i + 1..words.size - 1) {
                val map = HashMap<Char, Char>()
                var flag = true
                for (k in 0..words[j].length - 1) {
                    val a = words[i][k]
                    val b = words[j][k]
                    if (map.containsKey(a)) {
                        if (map.get(a) != b) {
                            flag = false
                            break
                        }
                    } else {
                        for (key in map.keys) {
                            if (map.get(key) == b) {
                                flag = false
                                break
                            }
                        }
                        if (flag) {
                            map.put(a, b)
                        }
                    }
                }
                if (flag) {
                    res++
                }
            }
        }
        print(res)
    }
}