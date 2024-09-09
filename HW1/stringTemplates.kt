/* Original code:

    fun main() {
        val discountPercentage: Int = 0
        val offer: String = ""
        val item = "Google Chromecast"
        discountPercentage = 20
        offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"

        println(offer)
}

    Problem: 'val' cannot ben reassigned, change it to 'var'
 */
fun main(){

    var discountPercentage: Int = 0
    var offer: String = ""
    val item = "Google Chromecast"
    discountPercentage = 20
    offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"

    println(offer)
}