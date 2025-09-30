import StateMachine.currentState
import java.util.Scanner

/**
 * Estado de la máquina de café
 * Obliga a todos los estados a implementar la función onEnter
 * Verifica que se realice una acción al entrar en un estado
 */
interface IMaquinaCafeEstados {
    fun onEnter(stateMachine: StateMachine) // Acción al entrar en el estado
}

/**
 * Estados de la máquina de cafe
 */
sealed class MaquinaCafeEstados: IMaquinaCafeEstados {
    object Idle : MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) { // Acción al entrar en el estado Idle
            println("Entrando en estado Idle")
            println("Esperando opciones")
            stateMachine.setState(Opciones)
        }
    }

    object Opciones : MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) { // Acción al entrar en el estado Opciones
            println("Entrando en estado Opciones")
            println("1.Soltar Leche")
            println("2.Calentar agua")
            println("Elige una opcion: ")
            var opcion = listOf(1, 2).random()
            when (opcion) {
                1 -> stateMachine.setState(SoltarLeche)
                2 -> stateMachine.setState(CalentarAgua)
            }
        }
    }

    object CalentarAgua : MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) { // Acción al entrar en el estado CalentarAgua
            println("Entrando en estado CalentarAgua")
            println("Calentando el agua")
            stateMachine.setState(SoltarLeche.SoltarCafe)
        }
    }

    object SoltarLeche : MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) { // Acción al entrar en el estado SoltarLeche
            println("Entrando en estado SoltarLeche")
            println("Soltando Leche")
            var opcion = listOf(1, 2).random()
            when (opcion) {
                1 -> stateMachine.setState(SoltarAzucar)
                2 -> stateMachine.setState(CalentarAgua)
            }
        }

        object SoltarAzucar : MaquinaCafeEstados(){
            override fun onEnter(stateMachine: StateMachine) { // Acción al entrar en el estado SoltarAzucar
                println("Entrando en estado SoltarAzucar")
                println("Soltando azucar")
                stateMachine.setState(CalentarAgua)
                return
            }
        }

        object SoltarCafe : MaquinaCafeEstados() {
            override fun onEnter(stateMachine: StateMachine) { // Acción al entrar en el estado SoltarCafe
                println("Entrando en estado SoltarCafe")
                println("Soltando cafe")
                println("fin")
                stateMachine.setState(Idle)
                return
            }
        }

        data class Error(val texto: String) : MaquinaCafeEstados() {
            override fun onEnter(stateMachine: StateMachine) { // Acción al entrar en el estado Error
                println("Entrando en estado Error")
                println("Hay algun error")
                stateMachine.setState(Idle)
            }
        }
    }
}