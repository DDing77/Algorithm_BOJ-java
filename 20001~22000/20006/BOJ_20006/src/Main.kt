import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = BufferedReader(InputStreamReader(System.`in`)).run {
    val sb = StringBuilder()
    var st = StringTokenizer(readLine(), " ")
    val p: Int = st.nextToken().toInt()
    val m: Int = st.nextToken().toInt()

    val roomList = mutableListOf<Room>()

    repeat(p) {
        st = StringTokenizer(readLine())
        val l: Int = st.nextToken().toInt()
        val n: String = st.nextToken()
        val member = Member(l, n)

        var flag = false

        for (room in roomList) {
            if (room.validationJoin(l)) {
                room.addMember(member)
                flag = true
                break
            }
        }

        if (!flag) {
            val room = Room(l, n, m)
            room.addMember(member)
            roomList.add(room)
        }
    }

    for (room in roomList) {
        sb.append(room.getStatus()).append("\n")
        room.members.sortBy { it.name }
        for (member in room.members) {
            sb.append(member.level).append(" ").append(member.name).append("\n")
        }
    }

    print(sb.toString())
}

private class Room(val level: Int, val name: String, val maxPool: Int) {
    val members = mutableListOf<Member>()

    fun addMember(member: Member) {
        members.add(member)
    }

    fun validationJoin(level: Int): Boolean {
        return (this.level - 10 <= level && level <= this.level + 10) && members.size < maxPool
    }

    fun getStatus(): String {
        return when (members.size == maxPool) {
            true -> "Started!"
            false -> "Waiting!"
        }
    }
}

private class Member(val level: Int, val name: String)