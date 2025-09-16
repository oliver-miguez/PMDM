package example.myapp

fun buildAquarium(){
//    val myAquarium = Aquarium()
//    myAquarium.printSize()
//    myAquarium.height = 2000
//    myAquarium.printSize()
//
//    val aquarium2 = Aquarium(height = 1200)
//    aquarium2.printSize()
//
//    val aquarium3 = Aquarium(height = 378785, length = 60787878)
//    aquarium3.printSize()
//
//    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
//    aquarium4.printSize()

    val aquarium5 = Aquarium(numberOfFish = 29)
    aquarium5.printSize()
    println("Volumen con el constructor secundario: ${aquarium5.width * aquarium5.length * aquarium5.height / 1000} LITROS")
}

fun main() {
    buildAquarium()
}