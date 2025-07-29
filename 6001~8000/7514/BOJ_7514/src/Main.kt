import java.math.BigInteger

fun main() {

    fun String.toBigInt(radix: Int): BigInteger {
        return BigInteger(this, radix)
    }

    fun BigInteger.toBase(radix: Int): String {
        return this.toString(radix)
    }

    fun isPalindrome(str: String): Boolean {
        return str == str.reversed()
    }

    fun reverseAndAdd(n: BigInteger, base: Int): BigInteger {
        val reversedStr = n.toBase(base).reversed()
        val reversedNum = BigInteger(reversedStr, base)
        return n + reversedNum
    }

    val sb = StringBuilder()
    val t = readln().toInt()
    repeat(t) { caseNum ->
        val (base, maxIter) = readln().split(" ").map { it.toInt() }
        val (start, end) = readln().split(" ").map { it.toBigInt(base) }

        var countFail = 0
        for (i in 0..(end - start).toInt()) {
            var current = start + BigInteger.valueOf(i.toLong())
            var iter = 0
            var found = false
            while (iter < maxIter) {
                val str = current.toBase(base)
                if (isPalindrome(str)) {
                    found = true
                    break
                }
                current = reverseAndAdd(current, base)
                iter++
            }
            if (!found && !isPalindrome(current.toBase(base))) {
                countFail++
            }
        }

        sb.append("Scenario ${caseNum + 1}:").append("\n")
        sb.append(countFail).append("\n")
    }
    print(sb)
}
