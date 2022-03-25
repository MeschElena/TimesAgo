fun main() {
    val timesAgoSec = 3660
    val result = agoToText(timesAgoSec)
    println("был(а) в сети $result")
}

fun agoToText(timesAgo: Int): String {
    val minuteSec = 60
    val hourSec = 3_600
    val daySec = 86_400
    val twoDaySec = daySec * 2
    val threeDaySec = daySec * 3
    val minute = "минута"
    val hour = "час"

    return when {
        timesAgo <= minuteSec -> "только что"
        timesAgo <= hourSec -> "${declension(timesAgo / minuteSec, minute)} назад"
        timesAgo <= daySec -> "${declension(timesAgo / hourSec, hour)} назад"
        timesAgo <= twoDaySec -> "сегодня"
        timesAgo <= threeDaySec -> "вчера"
        else -> "давно"
    }
}

fun declension(count: Int, hourDay: String): String {
    val countDelTen = count % 10
    val countDelHund = count % 100

    return if (hourDay == "минута") {
        when {
            countDelTen == 1 && countDelHund !in 10..19 -> "$count минуту"
            countDelTen < 5 && countDelHund !in 10..19 -> "$count минуты"
            else -> "$count минут"
        }
    } else {
        when {
            countDelTen == 1 && countDelHund !in 10..19 -> "$count час"
            countDelTen < 5 && countDelHund !in 10..19 -> "$count часа"
            else -> "$count часов"
        }
    }
}