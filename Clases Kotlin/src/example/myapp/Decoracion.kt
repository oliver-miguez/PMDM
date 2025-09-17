package example.myapp

//las clases data son clases diseñadas para administrar informacion, pero esta se sigue considerando un objeto
data class Decoration(val rocks: String) {
}
fun makeDecorations() {


    val decoration1 = Decoration("granite")
    println(decoration1)

    val decoration2 = Decoration("slate")
    println(decoration2)

    val decoration3 = Decoration("slate")
    println(decoration3)

    //compara las decoraciones
    println (decoration1.equals(decoration2))
    println (decoration3.equals(decoration2))

    val d5 = Decoration2("crystal", "wood", "diver")
    println(d5)

    // Assign all properties to variables.
    val (rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)


}


// Clase data con 3 propiedades
data class Decoration2(val rocks: String, val wood: String, val diver: String){
}


fun main(){
    makeDecorations()
    println(Direction.EAST.name)
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degrees)
    println(Color.RED)
    var prueba1 = SeaLion()
    println(matchSeal(prueba1))
}

//reescribimos la interfaz(podemos crear objets en archivos que no sean interfaces)
object GoldColor : FishColor {
    override val color = "gold"
}
//Permite enumerar cosas y referirse a ellas por el nombre
enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
}
enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

//solo se pueden crear subclases de esta en este archivo
sealed class Seal
class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
    return when(seal) {
        is Walrus -> "walrus"
        is SeaLion -> "sea lion"
    }
}

