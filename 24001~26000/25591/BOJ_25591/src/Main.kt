import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (x, y) = br.readLine().split(" ").map { it.toInt() }

        val a = 100 - x
        val b = 100 - y
        var c = 100 - (a + b)
        val d = a * b
        val q = d / 100
        val r = d % 100

        println("$a $b $c $d $q $r")
        print("${c + q} $r")
    }
}