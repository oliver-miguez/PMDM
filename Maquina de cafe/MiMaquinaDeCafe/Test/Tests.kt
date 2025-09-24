// Test/Tests.kt
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaquinaCafeStateMachineTests {

    @Test
    fun testIdleAOpciones() {
        MaquinaCafe.currentState = MaquinaCafeEstados.Idle
        MaquinaCafe.funcionamientoMaquina()
        assertTrue(MaquinaCafe.currentState is MaquinaCafeEstados.Opciones)
    }

    @Test
    fun testOpcionesASoltarLecheOCalentarAgua() {
        MaquinaCafe.currentState = MaquinaCafeEstados.Opciones
        MaquinaCafe.funcionamientoMaquina()
        assertTrue(
            MaquinaCafe.currentState is MaquinaCafeEstados.SoltarLeche ||
                    MaquinaCafe.currentState is MaquinaCafeEstados.CalentarAgua
        )
    }

    @Test
    fun testCalentarAguaASoltarCafe() {
        MaquinaCafe.currentState = MaquinaCafeEstados.CalentarAgua
        MaquinaCafe.funcionamientoMaquina()
        assertTrue(MaquinaCafe.currentState is MaquinaCafeEstados.SoltarCafe)
    }

    @Test
    fun testSoltarLecheASoltarAzucarOCalentarAgua() {
        MaquinaCafe.currentState = MaquinaCafeEstados.SoltarLeche
        MaquinaCafe.funcionamientoMaquina()
        assertTrue(
            MaquinaCafe.currentState is MaquinaCafeEstados.SoltarAzucar ||
                    MaquinaCafe.currentState is MaquinaCafeEstados.CalentarAgua
        )
    }

    @Test
    fun testSoltarCafeFin() {
        MaquinaCafe.currentState = MaquinaCafeEstados.SoltarCafe
        MaquinaCafe.funcionamientoMaquina()
        // El estado no cambia, solo termina la función
        assertTrue(MaquinaCafe.currentState is MaquinaCafeEstados.SoltarCafe)
    }

    @Test
    fun testSoltarAzucarACalentarAgua() {
        MaquinaCafe.currentState = MaquinaCafeEstados.SoltarAzucar(true)
        MaquinaCafe.funcionamientoMaquina()
        assertTrue(MaquinaCafe.currentState is MaquinaCafeEstados.CalentarAgua)
    }
}
