import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val s = br.readLine() ?: return println("Error!")

        fun isC(str: String): Boolean {
            if (str.isEmpty()) return false
            if (str.first() == '_' || str.last() == '_') return false
            var prevUnderscore = false
            for (c in str) {
                when {
                    c in 'a'..'z' -> prevUnderscore = false
                    c == '_' -> {
                        if (prevUnderscore) return false
                        prevUnderscore = true
                    }
                    else -> return false
                }
            }
            return true
        }

        fun isJava(str: String): Boolean {
            if (str.isEmpty()) return false
            if (str[0] !in 'a'..'z') return false
            for (c in str) {
                if (c == '_') return false // '_' 금지
                if (!(c in 'a'..'z' || c in 'A'..'Z')) return false
            }
            return true
        }

        fun cToJava(str: String): String {
            val sb = StringBuilder()
            var upperNext = false
            for (c in str) {
                if (c == '_') {
                    upperNext = true
                } else {
                    if (upperNext) {
                        sb.append(c.uppercaseChar())
                        upperNext = false
                    } else {
                        sb.append(c)
                    }
                }
            }
            return sb.toString()
        }

        fun javaToC(str: String): String {
            val sb = StringBuilder()
            for (c in str) {
                if (c in 'A'..'Z') {
                    sb.append('_')
                    sb.append(c.lowercaseChar())
                } else {
                    sb.append(c)
                }
            }
            return sb.toString()
        }

        when {
            isC(s) -> print(cToJava(s))
            isJava(s) -> print(javaToC(s))
            else -> print("Error!")
        }
    }
}
