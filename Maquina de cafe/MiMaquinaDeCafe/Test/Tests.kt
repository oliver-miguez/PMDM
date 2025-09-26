// Test/Tests.kt
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaquinaCafeStateMachineTests {

    @Test
    fun testIdleAOpciones() {
        StateMachine.currentState = MaquinaCafeEstados.Idle
        StateMachine.funcionamientoMaquina()
        assertTrue(StateMachine.currentState is MaquinaCafeEstados.Opciones)
    }

    @Test
    fun testOpcionesASoltarLecheOCalentarAgua() {
        StateMachine.currentState = MaquinaCafeEstados.Opciones
        StateMachine.funcionamientoMaquina()
        assertTrue(
            StateMachine.currentState is MaquinaCafeEstados.SoltarLeche ||
                    StateMachine.currentState is MaquinaCafeEstados.CalentarAgua
        )
    }

    @Test
    fun testCalentarAguaASoltarCafe() {
        StateMachine.currentState = MaquinaCafeEstados.CalentarAgua
        StateMachine.funcionamientoMaquina()
        assertTrue(StateMachine.currentState is MaquinaCafeEstados.SoltarCafe)
    }

    @Test
    fun testSoltarLecheASoltarAzucarOCalentarAgua() {
        StateMachine.currentState = MaquinaCafeEstados.SoltarLeche
        StateMachine.funcionamientoMaquina()
        assertTrue(
            StateMachine.currentState is MaquinaCafeEstados.SoltarAzucar ||
                    StateMachine.currentState is MaquinaCafeEstados.CalentarAgua
        )
    }

    @Test
    fun testSoltarCafeFin() {
        StateMachine.currentState = MaquinaCafeEstados.SoltarCafe
        StateMachine.funcionamientoMaquina()
        // El estado no cambia, solo termina la función
        assertTrue(StateMachine.currentState is MaquinaCafeEstados.SoltarCafe)
    }

    @Test
    fun testSoltarAzucarACalentarAgua() {
        StateMachine.currentState = MaquinaCafeEstados.SoltarAzucar(true)
        StateMachine.funcionamientoMaquina()
        assertTrue(StateMachine.currentState is MaquinaCafeEstados.CalentarAgua)
    }
}
