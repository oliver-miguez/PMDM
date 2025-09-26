/**
 * Estados de la máquina de cafe
 */
sealed class MaquinaCafeEstados {
    object Idle: MaquinaCafeEstados()
    object Opciones: MaquinaCafeEstados()
    object CalentarAgua: MaquinaCafeEstados()
    object SoltarLeche: MaquinaCafeEstados()
    data class SoltarAzucar(val soltar: Boolean): MaquinaCafeEstados()
    object  SoltarCafe: MaquinaCafeEstados()
    data class Error(val texto: String):MaquinaCafeEstados()
}