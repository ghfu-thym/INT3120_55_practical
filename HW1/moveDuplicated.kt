fun main() {
/*    println("City: Ankara")
    println("Low temperature: 27, High temperature: 31")
    println("Chance of rain: 82%")
    println()

    println("City: Tokyo")
    println("Low temperature: 32, High temperature: 36")
    println("Chance of rain: 10%")
    println()

    println("City: Cape Town")
    println("Low temperature: 59, High temperature: 64")
    println("Chance of rain: 2%")
    println()

    println("City: Guatemala City")
    println("Low temperature: 50, High temperature: 55")
    println("Chance of rain: 7%")
    println()
*/
    println(weather("Ankara", 27, 31, 82))
    println(weather("Tokyo", 32, 36, 10 ))
    println(weather("Cape Town", 59, 64, 2))
    println(weather("Guatemala City", 50, 55, 7))
}

fun weather(city: String, lowTemp: Int, highTemp: Int, chanceRain: Int): String{
    return "City: $city \n" +
            "Low temperature: $lowTemp, High temperture: $highTemp\n" +
            "Chance of rain: $chanceRain% \n"
}