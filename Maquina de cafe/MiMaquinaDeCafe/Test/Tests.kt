// Test/Tests.kt
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * Test para comprobar el funcionamiento de la maquina de café
 */
class MaquinaCafeStateMachineTests {

    @Test
    fun testInitialState() {
        // Verificar que el estado inicial es Idle
        assertTrue(StateMachine.getState() is MaquinaCafeEstados.Idle)
    }
    @Test
    fun testTransitionIdleToOpciones() {
        // Transición de Idle a Opciones
        StateMachine.setState(MaquinaCafeEstados.Idle)
        StateMachine.getState().onEnter(StateMachine)
        assertTrue(StateMachine.getState() is MaquinaCafeEstados.Opciones)
    }
    @Test
    fun testTransitionOpcionesToCalentarAgua() {
        // Transición de Opciones a CalentarAgua
        StateMachine.setState(MaquinaCafeEstados.Opciones)
        StateMachine.setState(MaquinaCafeEstados.CalentarAgua)
        assertTrue(StateMachine.getState() is MaquinaCafeEstados.CalentarAgua)
    }
    @Test
    fun testTransitionOpcionesToSoltarLeche() {
        // Transición de Opciones a SoltarLeche
        StateMachine.setState(MaquinaCafeEstados.Opciones)
        StateMachine.setState(MaquinaCafeEstados.SoltarLeche)
        assertTrue(StateMachine.getState() is MaquinaCafeEstados.SoltarLeche)
    }
    @Test
    fun testTransitionCalentarAguaToSoltarLeche() {
        // Transición de CalentarAgua a SoltarLeche
        StateMachine.setState(MaquinaCafeEstados.CalentarAgua)
        StateMachine.setState(MaquinaCafeEstados.SoltarLeche)
        assertTrue(StateMachine.getState() is MaquinaCafeEstados.SoltarLeche)
    }
    @Test
    fun testTransitionSoltarLecheToSoltarAzucar() {
        // Transición de SoltarLeche a SoltarAzucar
        StateMachine.setState(MaquinaCafeEstados.SoltarLeche)
        StateMachine.setState(MaquinaCafeEstados.SoltarLeche.SoltarAzucar)
        assertTrue(StateMachine.getState() is MaquinaCafeEstados.SoltarLeche.SoltarAzucar)
    }
    @Test
    fun testTransitionSoltarAzucarToSoltarCafe() {
        // Transición de SoltarAzucar a SoltarCafe
        StateMachine.setState(MaquinaCafeEstados.SoltarLeche.SoltarAzucar)
        StateMachine.setState(MaquinaCafeEstados.SoltarLeche.SoltarCafe)
        assertTrue(StateMachine.getState() is MaquinaCafeEstados.SoltarLeche.SoltarCafe)
    }
    @Test
    fun testTransitionSoltarCafeToIdle() {
        // Transición de SoltarCafe a Idle
        StateMachine.setState(MaquinaCafeEstados.SoltarLeche.SoltarCafe)
        StateMachine.setState(MaquinaCafeEstados.Idle)
        assertTrue(StateMachine.getState() is MaquinaCafeEstados.Idle)
    }
}
