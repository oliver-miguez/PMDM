
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

    /**
     * Estado CalentarAgua, al entrar en este estado se calienta el agua y se pasa al siguiente estado
     */
    object CalentarAgua : MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) { // Acción al entrar en el estado CalentarAgua
            println("Entrando en estado CalentarAgua")
            println("Calentando el agua")
            stateMachine.setState(SoltarLeche)
        }
    }

    /**
     * Estado SoltarLeche, al entrar en este estado se suelta la leche y se pasa al siguiente estado
     */
    object SoltarLeche : MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) { // Acción al entrar en el estado SoltarLeche
            println("Entrando en estado SoltarLeche")
            println("Soltando Leche")
            stateMachine.setState(SoltarAzucar)
            }
        }

    /**
     * Estado SoltarAzucar, al entrar en este estado se suelta el azúcar y se pasa al siguiente estado
     */
        object SoltarAzucar : MaquinaCafeEstados(){
            override fun onEnter(stateMachine: StateMachine) { // Acción al entrar en el estado SoltarAzucar
                println("Entrando en estado SoltarAzucar")
                println("Soltando azucar")
                stateMachine.setState(SoltarCafe)
                return
            }
        }

    /**
     * Estado SoltarCafe, al entrar en este estado se suelta el café y se pasa al siguiente estado
     * Si no se sirve canela reseatea la máquina
     */
    object SoltarCafe : MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) { // Acción al entrar en el estado SoltarCafe
            println("Entrando en estado SoltarCafe")
            println("Soltando cafe")
            println("fin")
            if (deberiaServirCanela()) { // Simula la decisión de si se debe servir canela o no
                stateMachine.setState(PreparandoExtra("canela"))
            } else {
                stateMachine.setState(Resetear)
            }
        }
    }

    fun deberiaServirCanela(): Boolean {
        // Lógica para decidir si se debe servir canela o no
        return false // Por defecto, siempre sirve canela

    }
    /**
     * Estado Error, al entrar en este estado se muestra un mensaje de error y se pasa al estado Idle
     */
        data class Error(val texto: String) : MaquinaCafeEstados() {
            override fun onEnter(stateMachine: StateMachine) { // Acción al entrar en el estado Error
                println("Entrando en estado Error")
                println("Hay algun error")
                stateMachine.setState(Idle)
            }
        }

    /**
     * Estado PreparandoExtra, al entrar en este estado se prepara el extra y se pasa al siguiente estado
     */
    data class PreparandoExtra(val tipoDeExtra: String) : MaquinaCafeEstados() {
            override fun onEnter(stateMachine: StateMachine) {
                println("Entrando en PreparandoExtra, añadiendo extra:   ${tipoDeExtra}")
                stateMachine.setState(Resetear)
            }
        }

    /**
     * Estado Resetear, al entrar en este estado se resetea la máquina y se pasa al estado Idle
     */
        object Resetear : MaquinaCafeEstados() {
            override fun onEnter(stateMachine: StateMachine) { // Acción al entrar en el estado resetear
                println("Entrando en estado resetear")
                println("Reseteando la máquina")
                stateMachine.setState(Idle)
            }
        }
}
