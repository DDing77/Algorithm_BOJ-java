import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val (startHour, startMinute) = br.readLine().split(":").map { it.toInt() }
        val (toHour, toMinute) = br.readLine().split(":").map { it.toInt() }

        val que = ArrayDeque<Time>()
        val check = Array(24, { BooleanArray(60) })
        que.add(Time(startHour, startMinute, 0))
        check[startHour][startMinute] = true

        while (que.isNotEmpty()) {
            val cur = que.removeFirst()
            if (cur.hour == toHour && cur.minute == toMinute) {
                print(cur.count)
                return
            }
            var time1 = cur.plusMinute()
            if (!check[time1.hour][time1.minute]) {
                que.add(time1)
                check[time1.hour][time1.minute] = true
            }

            var time2 = cur.plusHour()
            if (!check[time2.hour][time2.minute]) {
                que.add(time2)
                check[time2.hour][time2.minute] = true
            }
        }
    }
}


data class Time(val hour: Int, val minute: Int, val count: Int = 0) {
    fun toSec(): Int {
        return (hour * 3600 + minute * 60)
    }

    fun plusMinute(): Time {
        var sec = toSec()
        sec += 60
        var hour = (sec / 3600) % 24
        var minute = (sec / 60) % 60
        return Time(hour, minute, count + 1)
    }

    fun plusHour(): Time {
        var sec = toSec()
        sec += 3600
        var hour = (sec / 3600) % 24
        var minute = (sec / 60) % 60
        return Time(hour, minute, count + 1)
    }
}