
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
            stateMachine.setState(CalentarAgua)
        }
    }

    object CalentarAgua : MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) { // Acción al entrar en el estado CalentarAgua
            println("Entrando en estado CalentarAgua")
            println("Calentando el agua")
            stateMachine.setState(SoltarLeche)
        }
    }

    object SoltarLeche : MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) { // Acción al entrar en el estado SoltarLeche
            println("Entrando en estado SoltarLeche")
            println("Soltando Leche")
            stateMachine.setState(SoltarAzucar)
            }
        }

        object SoltarAzucar : MaquinaCafeEstados(){
            override fun onEnter(stateMachine: StateMachine) { // Acción al entrar en el estado SoltarAzucar
                println("Entrando en estado SoltarAzucar")
                println("Soltando azucar")
                stateMachine.setState(SoltarCafe)
                return
            }
        }

        object SoltarCafe : MaquinaCafeEstados() {
            override fun onEnter(stateMachine: StateMachine) { // Acción al entrar en el estado SoltarCafe
                println("Entrando en estado SoltarCafe")
                println("Soltando cafe")
                println("fin")
                stateMachine.setState(PreparandoExtra("canela"))
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
       
        data class PreparandoExtra(val tipoDeExtra: String) : MaquinaCafeEstados() {
            override fun onEnter(stateMachine: StateMachine) {
                println("Entrando en PreparandoExtra, añadiendo extra:   ${tipoDeExtra}")
                stateMachine.setState(Resetear)
            }
        }
        object Resetear : MaquinaCafeEstados() {
            override fun onEnter(stateMachine: StateMachine) { // Acción al entrar en el estado resetear
                println("Entrando en estado resetear")
                println("Reseteando la máquina")
                stateMachine.setState(Idle)
            }
        }
}
