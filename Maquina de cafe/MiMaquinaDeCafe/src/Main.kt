/**
 * Simulación de una máquina de café utilizando un autómata finito.
 * La máquina tiene varios estados y transiciones entre ellos basadas en las acciones del usuario.
 */
fun main() {
    // Inicializar la máquina de café en el estado Idle
    StateMachine.updateState(MaquinaCafeEstados.Idle)

    // Simular el funcionamiento de la máquina de café
    while (true) {
        val currentState = StateMachine.getState()
        currentState.onEnter(StateMachine)

        // Salir del bucle si se alcanza el estado Idle después de completar una acción
        if (currentState is MaquinaCafeEstados.Idle) {
            println("Ciclo completo. La máquina está lista para una nueva operación.")
            break
        }
    }
}