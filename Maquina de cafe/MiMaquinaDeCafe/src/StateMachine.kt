import java.util.Scanner

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

        }
    }
}