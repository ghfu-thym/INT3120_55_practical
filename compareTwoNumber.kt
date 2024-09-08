fun main() {
    val timeSpentToday = 300
    val timeSpentYesterday = 250
    println(compare(timeSpentToday, timeSpentYesterday))
}

fun compare(timeSpentToday: Int, timeSpentYesterday: Int): Boolean {
    return timeSpentToday > timeSpentYesterday
}