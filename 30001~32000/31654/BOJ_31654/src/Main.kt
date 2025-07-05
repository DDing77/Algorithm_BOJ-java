import java.io.*
import java.util.StringTokenizer

fun main() = BufferedReader(InputStreamReader(System.`in`)).run {
    var st = StringTokenizer(readLine())
    var a = st.nextToken().toInt()
    var b = st.nextToken().toInt()
    var c = st.nextToken().toInt()

    when (a + b == c) {
        true -> println("correct!")
        false -> println("wrong!")
    }
}