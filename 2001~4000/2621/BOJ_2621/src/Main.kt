import java.io.BufferedReader
import java.io.InputStreamReader

data class Card(val color: String, val number: Int)

fun score900(cards: List<Card>): Boolean {
    for (i in 1..<cards.size) {
        if ((cards[i - 1].color != cards[i].color) || (cards[i - 1].number + 1 != cards[i].number)) {
            return false
        }
    }
    return true
}

fun score800Type1(cards: List<Card>): Boolean {
    if (cards[0].number == cards[1].number &&
        cards[1].number == cards[2].number &&
        cards[2].number == cards[3].number
    ) {
        return true
    }
    return false
}

fun score800Type2(cards: List<Card>): Boolean {
    if (cards[1].number == cards[2].number &&
        cards[2].number == cards[3].number &&
        cards[3].number == cards[4].number
    ) {
        return true
    }
    return false
}

fun score700Type1(cards: List<Card>): Boolean {
    if ((cards[0].number == cards[1].number &&
                cards[1].number == cards[2].number) &&
        (cards[3].number == cards[4].number)
    ) {
        return true
    }
    return false
}

fun score700Type2(cards: List<Card>): Boolean {
    if ((cards[0].number == cards[1].number) &&
        (cards[2].number == cards[3].number &&
                cards[3].number == cards[4].number)
    ) {
        return true
    }
    return false
}

fun score700Type3(cards: List<Card>): Boolean {
    if ((cards[0].number == cards[4].number) &&
        (cards[1].number == cards[2].number &&
                cards[2].number == cards[3].number)
    ) {
        return true
    }
    return false
}

fun score600(cards: List<Card>): Boolean {
    for (i in 1..<cards.size) {
        if (cards[i - 1].color != cards[i].color) return false
    }

    return true
}

fun score500(cards: List<Card>): Boolean {
    for (i in 1..<cards.size) {
        if (cards[i - 1].number + 1 != cards[i].number) return false
    }
    return true
}

fun score400Type1(cards: List<Card>): Boolean {
    if (cards[0].number == cards[1].number &&
        cards[1].number == cards[2].number
    ) {
        return true
    }
    return false
}

fun score400Type2(cards: List<Card>): Boolean {
    if (cards[1].number == cards[2].number &&
        cards[2].number == cards[3].number
    ) {
        return true
    }
    return false
}

fun score400Type3(cards: List<Card>): Boolean {
    if (cards[2].number == cards[3].number &&
        cards[3].number == cards[4].number
    ) {
        return true
    }
    return false
}

fun score300Type1(cards: List<Card>): Boolean {
    if (cards[0].number == cards[1].number &&
        cards[2].number == cards[3].number &&
        cards[0].number != cards[2].number &&
        cards[0].number != cards[4].number &&
        cards[2].number != cards[4].number
    ) {
        return true
    }
    return false
}

fun score300Type2(cards: List<Card>): Boolean {
    if (cards[0].number == cards[1].number &&
        cards[2].number == cards[4].number &&
        cards[0].number != cards[2].number &&
        cards[0].number != cards[3].number &&
        cards[2].number != cards[3].number
    ) {
        return true
    }
    return false
}

fun score300Type3(cards: List<Card>): Boolean {
    if (cards[0].number == cards[1].number &&
        cards[3].number == cards[4].number &&
        cards[0].number != cards[3].number &&
        cards[0].number != cards[2].number &&
        cards[3].number != cards[2].number
    ) {
        return true
    }
    return false
}

fun score300Type4(cards: List<Card>): Boolean {
    if (cards[0].number == cards[2].number &&
        cards[3].number == cards[4].number &&
        cards[0].number != cards[3].number &&
        cards[0].number != cards[1].number &&
        cards[3].number != cards[1].number
    ) {
        return true
    }
    return false
}
fun score300Type5(cards: List<Card>): Boolean {
    if (cards[1].number == cards[2].number &&
        cards[3].number == cards[4].number &&
        cards[1].number != cards[3].number &&
        cards[0].number != cards[1].number &&
        cards[0].number != cards[3].number
    ) {
        return true
    }
    return false
}

fun score200Type1(cards: List<Card>): Boolean {
    if (cards[0].number == cards[1].number &&
        cards[0].number != cards[2].number &&
        cards[0].number != cards[3].number &&
        cards[0].number != cards[4].number
    ) {
        return true
    }
    return false
}

fun score200Type2(cards: List<Card>): Boolean {
    if (cards[1].number == cards[2].number &&
        cards[1].number != cards[0].number &&
        cards[1].number != cards[3].number &&
        cards[1].number != cards[4].number
    ) {
        return true
    }
    return false
}

fun score200Type3(cards: List<Card>): Boolean {
    if (cards[2].number == cards[3].number &&
        cards[2].number != cards[0].number &&
        cards[2].number != cards[1].number &&
        cards[2].number != cards[4].number
    ) {
        return true
    }
    return false
}

fun score200Type4(cards: List<Card>): Boolean {
    if (cards[3].number == cards[4].number &&
        cards[3].number != cards[0].number &&
        cards[3].number != cards[1].number &&
        cards[3].number != cards[2].number
    ) {
        return true
    }
    return false
}

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val cardList = ArrayList<Card>()
        repeat(5) {
            val (color, number) = br.readLine().split(" ")
            cardList.add(Card(color, number.toInt()))
        }

        cardList.sortWith(compareBy<Card> { it.number }.thenBy { it.color })

        when {
            score900(cardList) -> {
                print(cardList[4].number + 900)
                return
            }

            score800Type1(cardList) -> {
                print(cardList[0].number + 800)
                return
            }

            score800Type2(cardList) -> {
                print(cardList[4].number + 800)
                return
            }

            score700Type1(cardList) -> {
                print(700 + cardList[4].number + cardList[0].number * 10)
                return
            }

            score700Type2(cardList) -> {
                print(700 + cardList[0].number + cardList[4].number * 10)
                return
            }

            score700Type3(cardList) -> {
                print(700 + cardList[0].number + cardList[1].number * 10)
                return
            }

            score600(cardList) -> {
                print(cardList[4].number + 600)
                return
            }

            score500(cardList) -> {
                print(cardList[4].number + 500)
                return
            }

            score400Type1(cardList) -> {
                print(cardList[0].number + 400)
                return
            }

            score400Type2(cardList) -> {
                print(cardList[1].number + 400)
                return
            }

            score400Type3(cardList) -> {
                print(cardList[2].number + 400)
                return
            }

            score300Type1(cardList) -> {
                print(cardList[1].number + cardList[3].number * 10 + 300)
                return
            }

            score300Type2(cardList) -> {
                print(cardList[0].number + cardList[4].number * 10 + 300)
                return
            }

            score300Type3(cardList) -> {
                print(cardList[0].number + cardList[4].number * 10 + 300)
                return
            }

            score300Type4(cardList) -> {
                print(cardList[0].number + cardList[4].number * 10 + 300)
                return
            }

            score300Type5(cardList) -> {
                print(cardList[1].number + cardList[4].number * 10 + 300)
                return
            }

            score200Type1(cardList) -> {
                print(cardList[0].number + 200)
                return
            }

            score200Type2(cardList) -> {
                print(cardList[1].number + 200)
                return
            }

            score200Type3(cardList) -> {
                print(cardList[2].number + 200)
                return
            }

            score200Type4(cardList) -> {
                print(cardList[3].number + 200)
                return
            }
        }

        print(cardList[4].number + 100)
    }
}