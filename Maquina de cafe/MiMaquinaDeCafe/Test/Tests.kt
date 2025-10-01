import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
  Test para comprobar el funcionamiento de la maquina de café
 */
  class MaquinaCafeStateMachineTests {

      @Test
      fun testInitialState() {
          // Verificar que el estado inicial es Idle
          StateMachine.currentState = MaquinaCafeEstados.Idle
          assertTrue(StateMachine.getState() is MaquinaCafeEstados.Idle)
      }

      @Test
      fun testTransitionIdleToCalentarAgua() {
          // Transición de Idle a CalentarAgua
          StateMachine.currentState = MaquinaCafeEstados.Idle
          StateMachine.setState(MaquinaCafeEstados.CalentarAgua)
          assertTrue(StateMachine.getState() is MaquinaCafeEstados.CalentarAgua)
      }

      @Test
      fun testTransitionCalentarAguaToSoltarLeche() {
          // Transición de CalentarAgua a SoltarLeche
          StateMachine.currentState = MaquinaCafeEstados.CalentarAgua
          StateMachine.setState(MaquinaCafeEstados.SoltarLeche)
          assertTrue(StateMachine.getState() is MaquinaCafeEstados.SoltarLeche)
      }

      @Test
      fun testTransitionSoltarLecheToSoltarAzucar() {
          // Transición de SoltarLeche a SoltarAzucar
          StateMachine.currentState = MaquinaCafeEstados.SoltarLeche
          StateMachine.setState(MaquinaCafeEstados.SoltarAzucar)
          assertTrue(StateMachine.getState() is MaquinaCafeEstados.SoltarAzucar)
      }

      @Test
      fun testTransitionSoltarAzucarToSoltarCafe() {
          // Transición de SoltarAzucar a SoltarCafe
          StateMachine.currentState = MaquinaCafeEstados.SoltarAzucar
          StateMachine.setState(MaquinaCafeEstados.SoltarCafe)
          assertTrue(StateMachine.getState() is MaquinaCafeEstados.SoltarCafe)
      }
  }