fun main() {
    val operatingSystem = "Chrome OS"
    val emailId = "sample@gmail.com"

    println(displayAlertMessage(operatingSystem, emailId))
    println()
    println(displayAlertMessage(emailId))
    println()

    val secondUserOperatingSystem = "Windows"
    val secondUserEmailId = "user_two@gmail.com"

    println(displayAlertMessage(secondUserOperatingSystem, secondUserEmailId))
    println()

    val thirdUserOperatingSystem = "Mac OS"
    val thirdUserEmailId = "user_three@gmail.com"

    println(displayAlertMessage(thirdUserOperatingSystem, thirdUserEmailId))
    println()
}

fun displayAlertMessage(operatingSystem: String, emailId: String): String {
    return "There's a new sign-in request on $operatingSystem for your Google Account $emailId."
}

fun displayAlertMessage(emailId: String): String {
    return "There's a new sign-in request on unknown OS for your Google Account $emailId."
}