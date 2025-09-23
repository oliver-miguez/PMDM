/**
 * Máquina de estados con base en una máquina de café
 */
sealed class CoffeeMachineState{ // Es una clase cerrada, entonces solo podrán recibir estos estados CoffeMachineState
    //DEFINICIÓN DE LOS ESTADOS DE LA MÁQUINA DE CAFÉ
    object Idle: CoffeeMachineState() // Son estados Singleton, solo existirá uno de ellos durante el programa entero, son únicos
    object MakingCoffee: CoffeeMachineState()
    data class ServingCoffee(val brand: String): CoffeeMachineState() // Clase específica para guardar datos, solo tiene atributos
    data class Error(val message: String) : CoffeeMachineState()
}