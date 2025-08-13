import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->

        val (N, M) = br.readLine().split(" ").map { it.toInt() }
        val nameIdxTable = HashMap<String, Int>()
        var nameIdx = 0

        val rootName = br.readLine()
        nameIdxTable.put(rootName, nameIdx++)

        val childMap = HashMap<String, ArrayList<String>>()
        val nodes = HashMap<String, Pair<Int, Double>>()
        nodes.put(rootName, Pair(0, 1.0))

        repeat(N) {
            val (child, parentA, parentB) = br.readLine().split(" ")

            nodes.computeIfAbsent(parentA) { Pair(0, 0.0) }
            nodes.computeIfAbsent(parentB) { Pair(0, 0.0) }
            nodes.put(child, Pair(2, .0))

            childMap.computeIfAbsent(parentA) {
                ArrayList()
            }.add(child)

            childMap.computeIfAbsent(parentB) {
                ArrayList()
            }.add(child)
        }

        val que = ArrayDeque<String>()
        for (node in nodes) {
            if (node.value.first == 0) {
                que.add(node.key)
            }
        }

        while (que.isNotEmpty()) {
            val parentName = que.removeFirst()
            val parentVal = nodes[parentName]?.second ?: 0.0
            val children = childMap[parentName] ?: emptyList()

            for (child in children) {
                val (deg, acc) = nodes[child]!!
                val newDeg = deg - 1
                val newAcc = acc + parentVal

                if (newDeg == 0) {
                    nodes[child] = Pair(0, newAcc / 2.0)
                    que.add(child)
                } else {
                    nodes[child] = Pair(newDeg, newAcc)
                }
            }
        }

        var answer = ""
        var maxDeg = -1.0
        repeat(M) {
            val q = br.readLine()
            val v = nodes[q]?.second ?: 0.0
            if (v > maxDeg) {
                maxDeg = v
                answer = q
            }
        }

        println(answer)
    }
}