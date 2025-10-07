/**
 * Maquina de cafe con estados
 */
object StateMachine {
    var currentState:MaquinaCafeEstados = MaquinaCafeEstados.Idle

    /**
     * Permite el cambio de estado
     */
    fun setState(state: MaquinaCafeEstados) {
        if (funcionamientoMaquina(currentState,state)) {
            currentState = state
        }
    }
    
    /**
     * Obtiene el estado actual
     */
    fun getState(): MaquinaCafeEstados {
        return currentState
    }
    fun updateState(newState: MaquinaCafeEstados) {
        currentState = newState
        currentState.onEnter(this) // Llama a la acción al entrar en el nuevo estado
    }

    /**
     * Función que gestiona el funcionamiento de la máquina de café
     */
    fun funcionamientoMaquina(from:MaquinaCafeEstados, to:MaquinaCafeEstados): Boolean {
        return when (from){
            MaquinaCafeEstados.Idle -> to == MaquinaCafeEstados.CalentarAgua
            MaquinaCafeEstados.SoltarLeche -> to == MaquinaCafeEstados.SoltarAzucar
            MaquinaCafeEstados.SoltarAzucar  -> to == MaquinaCafeEstados.SoltarCafe
            MaquinaCafeEstados.CalentarAgua -> to == MaquinaCafeEstados.SoltarLeche
            MaquinaCafeEstados.SoltarCafe -> to == MaquinaCafeEstados.Resetear || to == MaquinaCafeEstados.PreparandoExtra("canela")
            MaquinaCafeEstados.Resetear -> to == MaquinaCafeEstados.Idle || to == MaquinaCafeEstados.PreparandoExtra("canela")
            is MaquinaCafeEstados.Error -> to == MaquinaCafeEstados.Idle
            is MaquinaCafeEstados.PreparandoExtra -> to == MaquinaCafeEstados.Resetear

            else -> false
        }
    }
}