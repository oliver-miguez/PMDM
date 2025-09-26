/**
 * Simulación de una máquina de café utilizando un autómata finito.
 * La máquina tiene varios estados y transiciones entre ellos basadas en las acciones del usuario.
 */
fun main() {
    while (true) {
        MaquinaCafe.funcionamientoMaquina()
        if (MaquinaCafe.currentState is MaquinaCafeEstados.SoltarCafe) {
            // Ejecuta la última transición y termina
            MaquinaCafe.funcionamientoMaquina()
            break
        }
    }
}
