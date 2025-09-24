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
