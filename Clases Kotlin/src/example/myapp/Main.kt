package example.myapp

fun buildAquarium(){
    val myAquarium = Aquarium()
    myAquarium.printSize()
    myAquarium.height = 2000
    myAquarium.printSize()

    val aquarium2 = Aquarium(height = 1200)
    aquarium2.printSize()

    val aquarium3 = Aquarium(height = 378785, length = 60787878)
    aquarium3.printSize()

    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()
    println("_________________________________---")
    val aquarium5 = Aquarium(numberOfFish = 29)
    aquarium5.printSize()
    println("Volumen con el constructor secundario: ${aquarium5.width * aquarium5.length * aquarium5.height / 1000} LITROS")
    println("_________________________________---")

    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
    aquarium6.volumen = 70 //proporciona el valor 70 al value del setter de Aquarium
    aquarium6.printSize()
    println("_________________________________---")

    val aquarium7 = Aquarium(length = 25, width = 25, height = 25)
    aquarium7.printSize()

    println("_________________________________---")

    val aquarium8 = Aquarium(length = 25, width = 25, height = 25)
    aquarium8.printSize()
    println(aquarium8.shape)
    val myTowerTank = TowerTank(40,25)
    println(myTowerTank.shape)
    myTowerTank.printSize()

}

fun main() {
    buildAquarium()
}