
/**
 * Maquina de cafe con estados
 */
object StateMachine {
    var currentState:MaquinaCafeEstados = MaquinaCafeEstados.Idle

    /**
     * Permite el cambio de estado
     */
    fun setState(state: MaquinaCafeEstados) {
        currentState = state
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
            is MaquinaCafeEstados.Idle -> to == MaquinaCafeEstados.Opciones
            is MaquinaCafeEstados.Opciones -> to ==  MaquinaCafeEstados.CalentarAgua || to == MaquinaCafeEstados.SoltarLeche.SoltarCafe
            is MaquinaCafeEstados.SoltarLeche -> to == MaquinaCafeEstados.SoltarLeche.SoltarAzucar || to == MaquinaCafeEstados.CalentarAgua
            is MaquinaCafeEstados.SoltarLeche.SoltarAzucar -> to == MaquinaCafeEstados.SoltarLeche.SoltarCafe
            is MaquinaCafeEstados.CalentarAgua -> to == MaquinaCafeEstados.SoltarLeche
            is MaquinaCafeEstados.SoltarLeche.SoltarCafe -> to == MaquinaCafeEstados.Idle
            is MaquinaCafeEstados.SoltarLeche.Error -> to == MaquinaCafeEstados.Idle
        }
    }
}