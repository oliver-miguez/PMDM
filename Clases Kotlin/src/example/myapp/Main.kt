package example.myapp

fun buildAquarium(){
    val myAquarium = Aquarium()
    myAquarium.printSize()
    myAquarium.height = 2000
    myAquarium.printSize()
}
fun main() {
    buildAquarium()
}