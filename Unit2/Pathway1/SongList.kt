package Unit2
fun main(){

}

class Song(
    val title: String,
    val artist: String,
    val year: Int,
    val play:Int
){
    fun isPopular():Boolean{
        if (play>=1000) return true
        return false
    }
    fun printDes(){
        println("$title, do $artist thực hiện, phát hành vào năm $year")
    }
}