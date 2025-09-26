import java.util.Scanner

/**
 * Maquina de cafe con estados
 */
object MaquinaCafe {
    var currentState:MaquinaCafeEstados = MaquinaCafeEstados.Idle

    /**
     * Función que gestiona el funcionamiento de la máquina de café
     */
    fun funcionamientoMaquina(){
        when(currentState){
            is MaquinaCafeEstados.Idle -> {
                println("Esperando opciones")
                currentState = MaquinaCafeEstados.Opciones


            }is MaquinaCafeEstados.SoltarCafe -> {
                println("Soltando cafe")
                println("fin")
                return
            }is MaquinaCafeEstados.Opciones ->{
                val sc: Scanner = Scanner(System.`in`)
                println("1.Soltar Leche")
                println("2.Calentar agua")
                println("Elige una opcion: ")
                var opcion = listOf(1,2).random()
                    when(opcion){
                        1 -> currentState = MaquinaCafeEstados.SoltarLeche
                        2 -> currentState = MaquinaCafeEstados.CalentarAgua
                    }
            }is MaquinaCafeEstados.CalentarAgua -> {
                println("Calentando el agua")
                currentState = MaquinaCafeEstados.SoltarCafe
            }is MaquinaCafeEstados.Error -> {
            println("Hay algun error")
            }is MaquinaCafeEstados.SoltarAzucar -> {
                println("Soltando el azucar")
                currentState = MaquinaCafeEstados.CalentarAgua
            }is MaquinaCafeEstados.SoltarLeche -> {
                println("Soltando Leche")
                var opcion = listOf(1,2).random()
                when(opcion) {
                    1 -> currentState = MaquinaCafeEstados.SoltarAzucar(true)
                    2 -> currentState = MaquinaCafeEstados.CalentarAgua
                }
            }
        }
    }
}