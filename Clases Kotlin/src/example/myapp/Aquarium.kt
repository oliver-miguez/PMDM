package example.myapp

import kotlin.math.tan
//Si le damos open a la clase le estaremos permitiendo crear subclases
open class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {
/*
    var width: Int = 20
    var height: Int = 40
    var length : Int = 100
*/

    //Los init se ejecutan por orden según aparezcan en el código
    //Se pueden usar todos lo que quieras
    init {
        println("Inicializando aquarium")
    }
/*
    init {
      1 litro = 1000cm³
        println("Volumen con el init : ${width * length * height / 1000} Litros")
    }
    */

    /*
    Se pueden crear varios constructores
    Según la documentación de kotlin solo debe existir un constructor principal
    Cada constructor secundario debe de llamar siempre al constructor original
    En este caso lo llama con un  :this()
    */
    constructor(numberOfFish: Int):this(){
        // 2000cm³ por pez + más un zona extra para no derramar el agua
        val tank = numberOfFish * 2000 * 1.1
        //calcular la altura necesaria
        height = (tank / (length * width)).toInt()
    }//end constructor secundario

    /*
    Como la clase tiene un open todas sus propiedades y variables ...
    Deberían estar marcados como open
     */
    open var volumen: Int
        //getter de volumen
        get() = width * height * length / 1000  // 1000 cm³ = 1 l
        //Value es el valor que nosotros le añadamos en la clase Kotlin
        set(value){
            height = (value * 1000) / (width * length)
        }

    open var shape = "Rectangulo"

    //Devuelve el 90% del volumen
    open var water: Double = 0.0
        get() = volumen * 0.9

    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        println("Volume:$volumen LITROS")
        println("Volumen: $volumen L Water: $water L (${water/volumen * 100.0}% full) ")
    }


}
