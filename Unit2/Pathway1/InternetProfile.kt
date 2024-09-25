package Unit2

fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}


class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println(
            "Name: $name \n" +
                    "Age: $age"
        )
        if (hobby != null) {
            print("Like to play $hobby. ")
        }
        if (referrer != null) {
            print("Has a referrer named ${referrer.name}")
            if (referrer.hobby != null) {
                print(", who like ${referrer.hobby}")
            }
        } else {
            print("Doesn't have a referer")
        }
        print("\n\n")
    }
}